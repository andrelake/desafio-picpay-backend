package com.andrelake.desafiopicpaybackend.services;

import com.andrelake.desafiopicpaybackend.domain.User;
import com.andrelake.desafiopicpaybackend.repositories.UserRepository;
import com.andrelake.desafiopicpaybackend.services.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public String createUser(UserDTO userDTO) {
        if (isNull(userDTO)) {
            throw new IllegalArgumentException("UserDTO cannot be null");
        }

        userRepository.save(new User(userDTO));
        return String.format("User %s %s created successfully", userDTO.getFirstName(), userDTO.getLastName());
    }
}
