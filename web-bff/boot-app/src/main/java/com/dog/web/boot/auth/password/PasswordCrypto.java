package com.dog.web.boot.auth.password;

import com.dog.web.auth.UserRegisterInput;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.function.UnaryOperator;

@Component
@RequiredArgsConstructor
public class PasswordCrypto {

    private final PasswordEncoder passwordEncoder;

    public UserRegisterInput cryptPassword(UserRegisterInput input) {
        input.user().getPassword(cryptApi());
        return input;
    }

    UnaryOperator<String> cryptApi() {
        return passwordEncoder::encode;
    }

}
