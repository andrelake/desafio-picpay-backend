package com.andrelake.desafiopicpaybackend.services;

import com.andrelake.desafiopicpaybackend.domain.User;
import com.andrelake.desafiopicpaybackend.exceptions.UserNotFoundException;
import com.andrelake.desafiopicpaybackend.repositories.UserRepository;
import com.andrelake.desafiopicpaybackend.services.dtos.UserDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public String createUser(UserDTO userDTO) {
        if (isNull(userDTO)) {
            throw new IllegalArgumentException("UserDTO cannot be null");
        }

        userRepository.save(new User(userDTO));
        return String.format("User %s %s created successfully", userDTO.getFirstName(), userDTO.getLastName());
    }

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public void save(@Valid User user) {
        userRepository.save(user);
    }

}
