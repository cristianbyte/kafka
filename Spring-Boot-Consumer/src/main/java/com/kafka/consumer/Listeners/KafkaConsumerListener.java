package com.kafka.consumer.Listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerListener {
    private Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);

    @KafkaListener(topics = {"my-topic"}, groupId = "my-group-id")
    public void Listener (String message){
        logger.info("Message:" +  message);
    }
}
