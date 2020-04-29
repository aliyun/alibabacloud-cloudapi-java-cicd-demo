package com.example.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class SwaggerApplication {

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication.run(SwaggerApplication.class, args);
    }

}
