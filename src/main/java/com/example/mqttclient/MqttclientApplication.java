package com.example.mqttclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@ServletComponentScan
@ComponentScan(basePackages = {"com.example"})
@SpringBootApplication
public class MqttclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqttclientApplication.class, args);
    }



}
