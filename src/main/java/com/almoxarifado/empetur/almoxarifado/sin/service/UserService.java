package com.almoxarifado.empetur.almoxarifado.sin.service;


import com.almoxarifado.empetur.almoxarifado.sin.dto.ItemDTO;
import com.almoxarifado.empetur.almoxarifado.sin.dto.UserDTO;
import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import com.almoxarifado.empetur.almoxarifado.sin.entity.User;
import com.almoxarifado.empetur.almoxarifado.sin.mapper.UserMapper;
import com.almoxarifado.empetur.almoxarifado.sin.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO create(UserDTO userDTO){
        User user = userMapper.dtoToUser(userDTO);
        User userSave = userRepository.save(user);
        return userMapper.userToDTO(userSave);
    }


    public List<UserDTO> list(){
        Sort sort = Sort.by("nomeCompleto").ascending();
        return userRepository.findAll(sort)
                .stream()
                .map(userMapper::userToDTO)
                .collect(Collectors.toList());
    }


    public UserDTO update(UserDTO userDTO){
        User user = userMapper.dtoToUser(userDTO);
        User userUpdate = userRepository.save(user);
        return userMapper.userToDTO(userUpdate);
    }

    public UserDTO delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User não encontrado com ID: " +id));

        UserDTO userDelete = userMapper.userToDTO(user);
        userRepository.delete(user);

        return userDelete;
    }

}
