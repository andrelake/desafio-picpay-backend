package com.andrelake.desafiopicpaybackend.services;

import com.andrelake.desafiopicpaybackend.domain.User;
import com.andrelake.desafiopicpaybackend.exceptions.UserNotAuthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.naming.ServiceUnavailableException;
import java.util.Map;

@Slf4j
@Service
public class AuthorizationService {

    private RestTemplate restTemplate;

    @Value("${api.authorization.url}")
    private String AUTHORIZATION_URL;

    public AuthorizationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void authorize(User user) throws ServiceUnavailableException {
        log.info("Authorizing {}...", user.getFirstName());
        ResponseEntity<Map> resp = restTemplate.getForEntity(AUTHORIZATION_URL, Map.class);

        if (!resp.getStatusCode().is2xxSuccessful()) {
            log.info("Error - Authorization Service is unavailable.");
            throw new ServiceUnavailableException("Error - Authorization Service is unavailable");
        }

        String authorizationMessage = resp.getBody().get("message").toString();
        if (!authorizationMessage.equals("Autorizado")) {
            log.info("Error - User not authorized.");
            throw new UserNotAuthorizedException("Error - User not authorized");
        }

        log.info("Authorized successfully.");
    }
}
