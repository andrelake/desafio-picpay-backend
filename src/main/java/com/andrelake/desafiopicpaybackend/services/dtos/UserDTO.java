package com.andrelake.desafiopicpaybackend.services.dtos;

import com.andrelake.desafiopicpaybackend.controllers.dtos.UserRequestDTO;
import com.andrelake.desafiopicpaybackend.domain.User;
import com.andrelake.desafiopicpaybackend.domain.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDTO {

    private String firstName;

    private String lastName;

    private String document;

    private String email;

    private String password;

    private UserType userType;

    public UserDTO(UserRequestDTO userRequestDTO) {
        this.firstName = userRequestDTO.getFirstName();
        this.lastName = userRequestDTO.getLastName();
        this.document = userRequestDTO.getDocument();
        this.email = userRequestDTO.getEmail();
        this.password = userRequestDTO.getPassword();
        this.userType = UserType.valueOf(userRequestDTO.getType().name());
    }

    public UserDTO(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.document = user.getDocument();
        this.email = user.getEmail();
        this.userType = user.getUserType();
    }
}
