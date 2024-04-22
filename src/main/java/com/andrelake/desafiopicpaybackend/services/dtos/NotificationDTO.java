package com.andrelake.desafiopicpaybackend.services.dtos;

import com.andrelake.desafiopicpaybackend.domain.User;

public record NotificationDTO(User user, String message) {
}
