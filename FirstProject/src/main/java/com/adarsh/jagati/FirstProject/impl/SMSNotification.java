package com.adarsh.jagati.FirstProject.impl;

import com.adarsh.jagati.FirstProject.NotificationService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class SMSNotification implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("SMS hai jii->  "+message);
    }
}
