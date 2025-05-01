package com.almoxarifado.empetur.almoxarifado.sin.mapper;

import com.almoxarifado.empetur.almoxarifado.sin.dto.UserDTO;
import com.almoxarifado.empetur.almoxarifado.sin.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToDTO(User user);

    User  dtoToUser(UserDTO userDTO);

}
