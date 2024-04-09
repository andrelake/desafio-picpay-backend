package com.andrelake.desafiopicpaybackend.exceptions;

import com.andrelake.desafiopicpaybackend.exceptions.dtos.ExceptionDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDTO> threatDataIntegrityViolation(DataIntegrityViolationException e) {
        return ResponseEntity.badRequest().body(new ExceptionDTO("Error - User already exists", HttpStatus.BAD_REQUEST.value()));
    }
}
