package com.dog.core.auth.domain.entity;

import com.dog.core.auth.domain.enums.TokenType;

public interface Token {

  Long id();
  String token();
  TokenType tokenType();
  boolean isRevoked();
  boolean isExpired();

}
