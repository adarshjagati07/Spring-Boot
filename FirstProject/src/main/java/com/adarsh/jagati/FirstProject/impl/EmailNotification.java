package com.adarsh.jagati.FirstProject.impl;

import com.adarsh.jagati.FirstProject.NotificationService;
import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements NotificationService {
    public void send(String message){
        System.out.println("Email hai jii->  "+message);
    }
}
