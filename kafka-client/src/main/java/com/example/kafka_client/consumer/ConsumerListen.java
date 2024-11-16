package com.example.kafka_client.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerListen {

    @KafkaListener(topics = "name", groupId = "simple")
    public void listen(String message) {
        System.out.println("Listening message: " + message);
    }
}
