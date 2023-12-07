package com.dog.web.boot.auth;

import com.dog.core.auth.UserApi;
import com.dog.core.auth.strict.UserApiStrict;
import com.dog.postgres.auth.repository.UserRepository;
import com.dog.postgres.auth.strict.UserApiStrictAdapter;
import com.dog.web.auth.UcRegistrarUsuario;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class AuthConfiguration {

    @Bean
    UserApiStrictAdapter userApiStrictAdapter(UserRepository userRepository){
        return new UserApiStrictAdapter(userRepository);
    }

    @Bean
    UserApiStrict userApiStrict(UserApiStrict.Port port){
        return new UserApiStrict(port);
    }

    @Bean
    UcRegistrarUsuario ucRegistrarUsuario(UserApi userApi){
        return new UcRegistrarUsuario(userApi);
    }

}
