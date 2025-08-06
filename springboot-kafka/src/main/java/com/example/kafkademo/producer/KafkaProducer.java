package com.example.kafkademo.producer;

import com.example.kafkademo.dto.MessageDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaProducer {

    private final KafkaTemplate<String, MessageDTO> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, MessageDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // 发送消息
    public void sendMessage(String topic, MessageDTO message) {
        ListenableFuture<SendResult<String, MessageDTO>> future =
                kafkaTemplate.send(topic, message);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, MessageDTO> result) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.err.println("Unable to send message=[" +
                        message + "] due to: " + ex.getMessage());
            }
        });
    }
}