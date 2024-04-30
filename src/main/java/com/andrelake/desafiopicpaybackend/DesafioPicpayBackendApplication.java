package com.andrelake.desafiopicpaybackend;

import com.andrelake.desafiopicpaybackend.infra.aws.AwsConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AwsConfigProperties.class)
public class DesafioPicpayBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafioPicpayBackendApplication.class, args);
    }

}
