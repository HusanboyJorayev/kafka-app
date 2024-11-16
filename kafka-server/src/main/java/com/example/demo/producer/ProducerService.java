package com.example.demo.producer;

import org.springframework.stereotype.Component;

@Component
public interface ProducerService {
    void sendMessage(String topic, String message);
}
