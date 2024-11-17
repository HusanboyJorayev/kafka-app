package com.example.demo.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topicName;

    @Value("${kafka.topic.name.2}")
    private String topicName2;

    @Override
    public void sendMessage(String message) {
        kafkaTemplate.send(topicName, message);

        System.out.println("Message sent to topic: " + topicName + " : " + message);
    }

    @Override
    public void sendUserDto(UserDto userDto) throws JsonProcessingException {
        UserDto dto = UserDto.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .age(userDto.getAge())
                .email(userDto.getEmail())
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(dto);

        kafkaTemplate.send(topicName2, json);

        System.out.println("Message sent to topic: " + topicName + " : " + json);
    }
}
