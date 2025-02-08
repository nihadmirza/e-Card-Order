package com.example.ecardorder;

import org.springframework.boot.SpringApplication;

public class TestECardOrderApplication {

    public static void main(String[] args) {
        SpringApplication.from(ECardOrderApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
