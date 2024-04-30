package com.andrelake.desafiopicpaybackend.services.aws;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.Topic;
import com.andrelake.desafiopicpaybackend.services.aws.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AwsSnsService {

    private AmazonSNS amazonSnsClient;
    private Topic topic;

    public AwsSnsService(AmazonSNS amazonSns, @Qualifier("snsTransactionTopic") Topic topic) {
        this.amazonSnsClient = amazonSns;
        this.topic = topic;
    }

    public void publish(MessageDTO message) {
        this.amazonSnsClient.publish(topic.getTopicArn(), message.message());
    }
}
