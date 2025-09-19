package com.example.kafkademo.controller;

import com.example.kafkademo.dto.MessageDTO;
import com.example.kafkademo.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @PostMapping("/send")
    @Transactional
    public String sendMessage(@RequestBody String content) {
        MessageDTO message = new MessageDTO();
        message.setId(UUID.randomUUID().toString());
        message.setContent(content);
        message.setTimestamp(LocalDateTime.now());
        message.setSender("user-" + System.currentTimeMillis() % 100);

        kafkaProducer.sendMessage("demo-topic", message);

        return "Message sent: " + content;
    }
}