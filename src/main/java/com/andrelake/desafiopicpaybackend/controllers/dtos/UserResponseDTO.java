package com.andrelake.desafiopicpaybackend.controllers.dtos;

import com.andrelake.desafiopicpaybackend.domain.enums.UserType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
public class UserResponseDTO {

    private String firstName;

    private String lastName;

    private String document;

    private String email;

    @Enumerated(EnumType.STRING)
    private UserType userType;

}
