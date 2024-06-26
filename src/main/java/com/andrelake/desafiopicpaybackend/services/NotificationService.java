package com.andrelake.desafiopicpaybackend.services;

import com.andrelake.desafiopicpaybackend.domain.User;
import com.andrelake.desafiopicpaybackend.services.dtos.NotificationResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.naming.ServiceUnavailableException;

@Slf4j
@Service
public class NotificationService {

    private RestTemplate restTemplate;

    @Value("${api.notification.url}")
    private String NOTIFICATION_URL;

    public NotificationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendNotification(User user) throws ServiceUnavailableException {
        log.info("Sending notification to {}.", user.getFirstName());
        ResponseEntity<NotificationResponseDTO> resp = restTemplate.getForEntity(NOTIFICATION_URL, NotificationResponseDTO.class);

        if (!resp.getStatusCode().is2xxSuccessful()) {
            log.info("Error - Notification Service is unavailable.");
            throw new ServiceUnavailableException("Error - Notification Service is unavailable");
        }

        log.info("Notification sent successfully.");
    }
}
