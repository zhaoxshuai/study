package com.example.kafkademo.consumer;

import com.example.kafkademo.dto.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class KafkaConsumer {

    // 正常消费消息
    @RetryableTopic(
            attempts = "4", // 重试次数
            backoff = @Backoff(delay = 1000, multiplier = 2.0), // 重试策略
            dltTopicSuffix = ".DLT" // 死信队列后缀
    )
    @KafkaListener(topics = "demo-topic", groupId = "demo-group")
    public void consumeMessages(List<MessageDTO> messages,
                                @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                                @Header(KafkaHeaders.OFFSET) List<Long> offsets) {

        for (int i = 0; i < messages.size(); i++) {
            MessageDTO message = messages.get(i);
            log.info("Received message='{}' from partition={}, offset={}",
                    message, partitions.get(i), offsets.get(i));

            // 业务处理逻辑
            processMessage(message);
        }
    }

    // 死信队列处理
    @DltHandler
    public void dltHandler(MessageDTO message) {
        log.error("!!! Dead Letter Topic received message: {}", message);
        // 死信处理逻辑（如记录日志、通知管理员等）
    }

    // 业务处理逻辑（模拟可能抛出异常的场景）
    private void processMessage(MessageDTO message) {
        if (message.getContent().contains("error")) {
            throw new RuntimeException("Simulated processing error for: " + message.getContent());
        }
        // 正常处理逻辑...
    }
}