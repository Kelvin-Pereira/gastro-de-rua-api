package com.dog.usecase.auth.repository;

public interface TokenUser {

    String accessToken();
    String refreshToken();

}
