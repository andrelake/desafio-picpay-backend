package com.andrelake.desafiopicpaybackend.exceptions;

import jakarta.persistence.PersistenceException;

public class UserNotFoundException extends PersistenceException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
