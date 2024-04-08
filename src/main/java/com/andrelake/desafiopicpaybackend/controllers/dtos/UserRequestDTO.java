package com.andrelake.desafiopicpaybackend.controllers.dtos;

import com.andrelake.desafiopicpaybackend.domain.enums.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserRequestDTO {

    @NotNull @NotBlank
    private String firstName;

    @NotNull @NotBlank
    private String lastName;

    @NotNull @NotBlank
    private String document;

    @NotNull @NotBlank
    private String email;

    @NotNull @NotBlank
    private String password;

    @NotNull
    private UserType type;
}
