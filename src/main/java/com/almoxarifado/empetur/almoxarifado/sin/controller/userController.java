package com.almoxarifado.empetur.almoxarifado.sin.controller;


import com.almoxarifado.empetur.almoxarifado.sin.dto.ItemDTO;
import com.almoxarifado.empetur.almoxarifado.sin.dto.UserDTO;
import com.almoxarifado.empetur.almoxarifado.sin.entity.User;
import com.almoxarifado.empetur.almoxarifado.sin.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {

    private UserService userService;

    public userController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<UserDTO> list() {
        return list();
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
        UserDTO createdItem = userService.create(userDTO);
        return ResponseEntity
                .created(URI.create("/api/itens/" + createdItem.getId()))
                .body(createdItem);
    }

    @PutMapping
    public UserDTO update(@RequestBody UserDTO userDTO){
        return userService.update(userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build(); // HTTP 204
    }




}
