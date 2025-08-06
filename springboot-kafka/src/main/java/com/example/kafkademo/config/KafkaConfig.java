package com.example.kafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
public class KafkaConfig {

    // 创建主题
    @Bean
    public NewTopic demoTopic() {
        return TopicBuilder.name("demo-topic")
                .partitions(3)       // 分区数
                .replicas(1)        // 副本数
                .compact()          // 使用压缩策略
                .build();
    }

    // 创建死信队列主题
    @Bean
    public NewTopic demoTopicDlt() {
        return TopicBuilder.name("demo-topic.DLT")
                .partitions(3)
                .replicas(1)
                .build();
    }

}