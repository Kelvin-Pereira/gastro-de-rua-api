package com.dog.web.auth.token;

import lombok.RequiredArgsConstructor;

import java.util.function.UnaryOperator;

@RequiredArgsConstructor
public class UcCryptoPassword implements UnaryOperator<String>{

    private final UnaryOperator<String> crypt;

    @Override
    public String apply(String password) {
        return crypt.apply(password);
    }
}
