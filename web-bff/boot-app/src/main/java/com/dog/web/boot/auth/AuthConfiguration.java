package com.dog.web.boot.auth;

import com.dog.core.auth.TokenApi;
import com.dog.core.auth.UserApi;
import com.dog.core.auth.UserRegisterApi;
import com.dog.web.auth.UcFindUserByEmailUser;
import com.dog.web.auth.UcRegistrarUsuario;
import com.dog.web.auth.token.UcCryptoToken;
import com.dog.web.auth.token.UcLogout;
import com.dog.web.auth.token.UcToken;
import com.dog.web.boot.auth.password.PasswordCrypto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration(proxyBeanMethods = false)

public class AuthConfiguration {

    @Bean
    UcRegistrarUsuario ucRegistrarUsuario(UserRegisterApi userRegisterApi, UcCryptoToken ucCryptoToken) {
        return new UcRegistrarUsuario(userRegisterApi, ucCryptoToken);
    }

    //Token
    @Bean
    UcToken ucToken(TokenApi tokenApi) {
        return new UcToken(tokenApi);
    }

    @Bean
    UcLogout ucLogout(UcToken ucToken) {
        return new UcLogout(ucToken);
    }

    //User
    @Bean
    UcFindUserByEmailUser ucFindUserByEmailUser(UserApi userApi){
        return new UcFindUserByEmailUser(userApi);
    }

    @Bean
    PasswordCrypto passwordCrypto(PasswordEncoder passwordCrypto){
        return new PasswordCrypto(passwordCrypto);
    }
    @Bean
    UcCryptoToken ucCryptoToken(PasswordCrypto passwordCrypto){
        return new UcCryptoToken(passwordCrypto.cryptApi());
    }


}
