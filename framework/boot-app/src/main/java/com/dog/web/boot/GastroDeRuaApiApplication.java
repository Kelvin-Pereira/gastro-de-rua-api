package com.dog.web.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableFeignClients
@EnableJpaRepositories(basePackages = {"com.dog.postgres"})
@SpringBootApplication
public class GastroDeRuaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GastroDeRuaApiApplication.class, args);
    }

}
