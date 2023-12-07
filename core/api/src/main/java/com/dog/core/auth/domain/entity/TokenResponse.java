package com.dog.core.auth.domain.entity;

import com.dog.core.auth.domain.enums.TokenType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class TokenResponse {

  private String accessToken;
  private TokenType refreshToken;

}
