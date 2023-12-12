package com.dog.usecase.auth.services.token;

import lombok.RequiredArgsConstructor;

import java.util.function.UnaryOperator;

@RequiredArgsConstructor
public class CryptoPasswordService implements UnaryOperator<String>{

    private final UnaryOperator<String> crypt;

    @Override
    public String apply(String password) {
        return crypt.apply(password);
    }
}
