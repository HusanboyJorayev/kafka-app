package com.example.demo.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/producer")
public class ProducerController {
    private final ProducerService producerService;

    @PostMapping("/sendMessage")
    public ResponseEntity<?> sendMessage(@RequestParam("message") String message) {
        producerService.sendMessage(message);
        return ResponseEntity.ok("Message sent");
    }

    @PostMapping("/sendUserDto")
    public ResponseEntity<?> sendUserDto(@RequestBody UserDto userDto) throws JsonProcessingException {
        producerService.sendUserDto(userDto);
        return ResponseEntity.ok("Message sent");
    }
}
