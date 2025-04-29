package com.almoxarifado.empetur.almoxarifado.sin.service;


import com.almoxarifado.empetur.almoxarifado.sin.entity.User;
import com.almoxarifado.empetur.almoxarifado.sin.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private  UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<User> create(User user){
        userRepository.save(user);
        return list();

    }

    public List<User> list(){
        Sort sort = Sort.by("nome").ascending();
        return userRepository.findAll(sort);
    }

    public List<User> update(User user){
        userRepository.save(user);
        return list();
    }

    public List<User> delete(Long id){
        userRepository.deleteById(id);
        return list();
    }




}
