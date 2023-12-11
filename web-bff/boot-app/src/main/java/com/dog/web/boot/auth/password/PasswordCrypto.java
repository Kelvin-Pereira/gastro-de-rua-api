package com.dog.web.boot.auth.password;

import com.dog.web.type.auth.UserRegisterType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.function.UnaryOperator;

@RequiredArgsConstructor
public class PasswordCrypto {

    private final PasswordEncoder passwordEncoder;

    public UnaryOperator<String> cryptApi() {
        return passwordEncoder::encode;
    }

}
