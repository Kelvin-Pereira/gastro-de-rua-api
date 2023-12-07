package com.dog.web.boot.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.dog.postgres"})
@EntityScan(basePackages = {"com.dog.postgres"})
public class BeanConfiguration {
}
