package com.ms.codify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ms.codify.*")
public class CodifyApplication {
    public static void main(String[] args){
        SpringApplication.run(CodifyApplication.class,args);
    }
}