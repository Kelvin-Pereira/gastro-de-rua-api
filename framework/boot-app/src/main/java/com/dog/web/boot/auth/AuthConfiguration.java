package com.dog.web.boot.auth;

import com.dog.usecase.auth.repository.TokenRepository;
import com.dog.usecase.auth.repository.UserRegisterRepository;
import com.dog.usecase.auth.repository.UserRepository;
import com.dog.usecase.auth.services.FindUserByEmailUserService;
import com.dog.usecase.auth.services.RegistrarUsuarioService;
import com.dog.usecase.auth.services.token.CryptoPasswordService;
import com.dog.usecase.auth.services.token.LogoutService;
import com.dog.usecase.auth.services.token.TokenService;
import com.dog.web.boot.auth.password.PasswordCrypto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration(proxyBeanMethods = false)

public class AuthConfiguration {

    @Bean
    RegistrarUsuarioService ucRegistrarUsuario(UserRegisterRepository userRegisterRepository, CryptoPasswordService cryptoPassWordService) {
        return new RegistrarUsuarioService(userRegisterRepository, cryptoPassWordService);
    }

    //Token
    @Bean
    TokenService ucToken(TokenRepository tokenRepository) {
        return new TokenService(tokenRepository);
    }

    @Bean
    LogoutService ucLogout(TokenService tokenService) {
        return new LogoutService(tokenService);
    }

    //User
    @Bean
    FindUserByEmailUserService ucFindUserByEmailUser(UserRepository userRepository){
        return new FindUserByEmailUserService(userRepository);
    }

    @Bean
    PasswordCrypto passwordCrypto(PasswordEncoder passwordCrypto){
        return new PasswordCrypto(passwordCrypto);
    }
    @Bean
    CryptoPasswordService ucCryptoToken(PasswordCrypto passwordCrypto){
        return new CryptoPasswordService(passwordCrypto.cryptApi());
    }


}
