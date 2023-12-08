package com.dog.core.auth.domain.entity;

import com.dog.core.auth.domain.enums.TokenType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public interface Token {

  Long id();
  String token();
  TokenType tokenType();
  boolean isRevoked();
  boolean isExpired();

}
