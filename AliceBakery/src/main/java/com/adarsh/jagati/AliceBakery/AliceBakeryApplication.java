package com.adarsh.jagati.AliceBakery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AliceBakeryApplication implements CommandLineRunner {

	public static void main(String[] args) {
        SpringApplication.run(AliceBakeryApplication.class, args);
	}
    @Autowired
    public CakeBaker cakeBaker;

    @Override
    public void run(String... args) throws Exception {
        cakeBaker.bakeCake();
    }
}
