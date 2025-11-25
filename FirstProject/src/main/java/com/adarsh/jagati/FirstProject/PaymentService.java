package com.adarsh.jagati.FirstProject;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    public PaymentService(String abc){
        System.out.println("hello jii"+abc);
    }
    public void pay(){
        System.out.println("Paying...");
    }

    @PostConstruct
    public void afterInit(){
        System.out.println("Aur kya haal hai!");
    }

    @PreDestroy
    public void beforeEnd(){
        System.out.println("Khatam, Gaya, Tata, ByeBye");
    }
}
