package com.andrelake.desafiopicpaybackend.infra.aws;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("aws")
public record AwsConfigProperties(String accessKey, String secretKey, String region, String arn) {

}
