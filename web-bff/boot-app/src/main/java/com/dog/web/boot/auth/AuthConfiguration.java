package com.dog.web.boot.auth;

import com.dog.core.auth.TokenApi;
import com.dog.core.auth.UserApi;
import com.dog.core.auth.UserRegisterApi;
import com.dog.core.auth.strict.UserApiStrict;
import com.dog.core.auth.strict.UserRegisterApiStrict;
import com.dog.core.auth.token.TokenApiStrict;
import com.dog.postgres.auth.repository.TokenRepository;
import com.dog.postgres.auth.repository.UserRepository;
import com.dog.postgres.auth.strict.UserApiStrictAdapter;
import com.dog.postgres.auth.strict.UserRegisterApiStrictAdapter;
import com.dog.postgres.auth.token.TokenApiStrictAdapter;
import com.dog.web.auth.UcFindUserByEmailUser;
import com.dog.web.auth.UcRegistrarUsuario;
import com.dog.web.auth.token.UcLogout;
import com.dog.web.boot.config.security.JwtExtract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration(proxyBeanMethods = false)

public class AuthConfiguration {


    // Register
    @Bean
    UserRegisterApiStrict userRegisterApiStrict(UserRegisterApiStrict.Port port) {
        return new UserRegisterApiStrict(port);
    }

    @Bean
    UcRegistrarUsuario ucRegistrarUsuario(UserRegisterApi userRegisterApi) {
        return new UcRegistrarUsuario(userRegisterApi);
    }

    //Token
    @Bean
    TokenApiStrict tokenApiStrict(TokenApiStrict.Port port) {
        return new TokenApiStrict(port);
    }

    @Bean
    UcLogout ucLogout(TokenApi tokenApi) {
        return new UcLogout(tokenApi);
    }


    //User
    @Bean
    UcFindUserByEmailUser ucFindUserByEmailUser(UserApi userApi){
        return new UcFindUserByEmailUser(userApi);
    }

    @Bean
    UserApiStrict userApiStrict(UserApiStrict.Port port){
        return new UserApiStrict(port);
    }

}
