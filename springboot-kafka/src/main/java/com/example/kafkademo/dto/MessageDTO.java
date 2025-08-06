package com.example.kafkademo.dto;

import java.time.LocalDateTime;
import lombok.Data;


@Data
public class MessageDTO {
    private String id;
    private String content;
    private LocalDateTime timestamp;
    private String sender;
}