package com.dog.web.boot.auth.config;

import com.dog.usecase.auth.repository.TokenRepository;
import com.dog.usecase.auth.repository.UserRegisterRepository;
import com.dog.usecase.auth.repository.UserRepository;
import com.dog.usecase.auth.services.token.*;
import com.dog.usecase.auth.services.user.FindUserByEmailUserService;
import com.dog.usecase.auth.services.user.RegistrarUsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration(proxyBeanMethods = false)

public class AuthConfigurationBeans {

    @Bean
    RegistrarUsuarioService ucRegistrarUsuario(UserRegisterRepository userRegisterRepository, CryptoPasswordService cryptoPassWordService) {
        return new RegistrarUsuarioService(userRegisterRepository, cryptoPassWordService);
    }

    //Token
    @Bean
    TokenService tokenService(TokenRepository tokenRepository) {
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

    @Bean
    ClaimsService claimsService() {
        return new ClaimsService();
    }

    @Bean
    TokenRevokeAllUserService tokenRevokeAllUserService(TokenService tokenService) {
        return new TokenRevokeAllUserService(tokenService);

    }

    @Bean
    TokenSaveService tokenSaveService(TokenService tokenService) {
        return new TokenSaveService(tokenService);
    }


}
