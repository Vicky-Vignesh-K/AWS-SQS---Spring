package com.queue.QueueProcessSQS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageProducer {

    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @PostMapping("sendMessage")
    public void sendMessage(@RequestParam String message){
        Message payload =  MessageBuilder.withPayload(message)
                .setHeader("sender","arun")
                .build();
        queueMessagingTemplate.send(endpoint,payload);
    }
}
