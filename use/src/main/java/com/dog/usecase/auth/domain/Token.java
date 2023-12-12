package com.dog.usecase.auth.domain;


import com.dog.usecase.auth.enums.TokenType;

public interface Token {

  Long id();
  String token();
  TokenType tokenType();
  boolean isRevoked();
  boolean isExpired();

}
