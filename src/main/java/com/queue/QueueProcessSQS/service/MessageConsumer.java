package com.queue.QueueProcessSQS.service;

import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @SqsListener(value = "MyQueue")
    public void receiveMessage(String message){
        System.out.println("Message Received " + message);
    }
}
