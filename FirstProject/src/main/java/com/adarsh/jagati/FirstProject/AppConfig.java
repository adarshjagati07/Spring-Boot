package com.adarsh.jagati.FirstProject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //for our customize bean, we can change its configuration!
    @Bean
    PaymentService paymentService(){
        return new PaymentService("I am Adarsh");
    }
}
