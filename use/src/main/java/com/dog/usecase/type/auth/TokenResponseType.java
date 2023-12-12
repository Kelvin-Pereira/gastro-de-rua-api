package com.dog.usecase.type.auth;

import com.dog.usecase.auth.repository.TokenUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class TokenResponseType {


  private String accessToken;

  private String refreshToken;

  public TokenResponseType(TokenUser tokenUser) {
    this.accessToken = tokenUser.accessToken();
    this.refreshToken = tokenUser.refreshToken();
  }

}
