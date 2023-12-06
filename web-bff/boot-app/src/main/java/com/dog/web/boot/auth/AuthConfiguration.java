package com.dog.web.boot.auth;

import com.dog.core.auth.UserApi;
import com.dog.web.auth.UcRegistrarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class AuthConfiguration {

    @Bean
    UcRegistrarUsuario ucRegistrarUsuario(UserApi userApi){
        return new UcRegistrarUsuario(userApi);
    }

}
