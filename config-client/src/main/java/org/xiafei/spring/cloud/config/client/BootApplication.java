package org.xiafei.spring.cloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class BootApplication {

    @Value("${name}")
    private String name;

    @RequestMapping("/")
    public String name() {
        return this.name;
    }



    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}