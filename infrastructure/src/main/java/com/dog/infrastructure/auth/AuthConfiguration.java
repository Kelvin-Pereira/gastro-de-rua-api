package com.dog.infrastructure.auth;

import com.dog.core.auth.UserApi;
import com.dog.usecase.auth.UcRegistrarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class AuthConfiguration {

    @Bean
    UcRegistrarUsuario ucRegistrarUsuario(UserApi userApi){
        return new UcRegistrarUsuario(userApi);
    }

}
