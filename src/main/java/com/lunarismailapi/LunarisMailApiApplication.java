package com.lunarismailapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class LunarisMailApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LunarisMailApiApplication.class, args);
    }

}
