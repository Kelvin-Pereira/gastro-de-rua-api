package com.dog.web.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.dog.postgres.auth.repository"})
@SpringBootApplication
public class GastroDeRuaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GastroDeRuaApiApplication.class, args);
    }

}
