package com.dog.web.boot.auth.password;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.function.UnaryOperator;

@RequiredArgsConstructor
public class PasswordCrypto {

    private final PasswordEncoder passwordEncoder;

    public UnaryOperator<String> cryptApi() {
        return passwordEncoder::encode;
    }

}
