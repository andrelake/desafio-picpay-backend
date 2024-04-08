package com.andrelake.desafiopicpaybackend.controllers;

import com.andrelake.desafiopicpaybackend.controllers.dtos.UserRequestDTO;
import com.andrelake.desafiopicpaybackend.services.UserService;
import com.andrelake.desafiopicpaybackend.services.dtos.UserDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(userService.createUser(new UserDTO(userRequestDTO)));
    }
}
