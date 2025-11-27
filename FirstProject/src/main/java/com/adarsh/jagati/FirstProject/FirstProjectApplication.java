package com.adarsh.jagati.FirstProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class FirstProjectApplication implements CommandLineRunner{

//    @Autowired
//    PaymentService paymentService;
//    @Autowired
//    NotificationService notificationService;

    @Autowired
    Map<String, NotificationService> notificationServiceMap = new HashMap<>();

    NotificationService notificationService;

//    public FirstProjectApplication(NotificationService notificationService){
//        this.notificationService = notificationService;
//        //constructor dependency injection
//        //now autowired is optional
//    }

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        for(var notificationService: notificationServiceMap.entrySet()){
            System.out.println(notificationService.getKey());
            notificationService.getValue().send("kese ho jii");
        }

//        paymentService.pay();
//        notificationService.send("radhe radhe");
    }
}
