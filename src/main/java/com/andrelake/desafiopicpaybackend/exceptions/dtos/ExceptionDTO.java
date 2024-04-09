package com.andrelake.desafiopicpaybackend.exceptions.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExceptionDTO {

    private String message;
    private int statusCode;

}
