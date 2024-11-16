package com.example.demo.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/producer")
public class ProducerController {
    private final ProducerService producerService;

    @PostMapping("/sendMessage")
    public ResponseEntity<?> sendMessage(String topic, String message) {
        producerService.sendMessage(topic, message);
        return ResponseEntity.ok("Message sent");
    }
}
