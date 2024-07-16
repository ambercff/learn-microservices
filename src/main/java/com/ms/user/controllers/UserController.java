package com.ms.user.controllers;

import com.ms.user.dtos.UserCreateDTO;
import com.ms.user.models.User;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserCreateDTO data){
        User user = new User(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }
}
