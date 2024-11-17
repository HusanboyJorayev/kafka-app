package com.example.demo.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

@Component
public interface ProducerService {
    void sendMessage(String message);

    void sendUserDto(UserDto userDto) throws JsonProcessingException;
}
