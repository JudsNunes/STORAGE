package com.almoxarifado.empetur.almoxarifado.sin.controller;


import com.almoxarifado.empetur.almoxarifado.sin.entity.User;
import com.almoxarifado.empetur.almoxarifado.sin.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {

    private UserService userService;

    public userController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    List<User> create(@RequestBody User user){
        return userService.create(user);
    }


    @GetMapping
    public List<User> list(){
        return list();
    }

    @PutMapping
    public List<User> update(@RequestBody User user){
        return userService.create(user);
    }

    @DeleteMapping("{id}")
    public List<User> delete(@PathVariable("id") Long id){
        return userService.delete(id);
    }



}
