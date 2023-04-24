package com.study.farmingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FarmingDemoApplication {
    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enable","false");
        System.setProperty("spring.main.log-startup-info","false");
        SpringApplication.run(FarmingDemoApplication.class, args);
    }

}
