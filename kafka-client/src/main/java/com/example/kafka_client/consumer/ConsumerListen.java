package com.example.kafka_client.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerListen {

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(ConsumerRecord<String, String> record) {
        System.out.println("Listening message: " + record.value());
    }

    @KafkaListener(topics = "${kafka.topic.name.2}", groupId = "${spring.kafka.consumer.group-id}")
    public void listenToUserDto(ConsumerRecord<String, String> record) throws JsonProcessingException {
        System.out.println("Listening message: " + record.value());
        ObjectMapper objectMapper = new ObjectMapper();
        UserDto userDto = objectMapper.readValue(record.value(), UserDto.class);
        System.out.println(userDto);
    }
}
