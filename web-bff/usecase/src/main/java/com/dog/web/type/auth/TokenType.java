package com.dog.web.type.auth;

import com.dog.core.auth.TokenUser;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenType {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;

    public TokenType(TokenUser tokenUser) {
        this.accessToken = tokenUser.accessToken();
        this.refreshToken = tokenUser.refreshToken();
    }
}
