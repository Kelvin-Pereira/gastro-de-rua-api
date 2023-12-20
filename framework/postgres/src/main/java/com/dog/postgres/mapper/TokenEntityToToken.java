package com.dog.postgres.mapper;

import com.dog.postgres.auth.domain.entity.TokenEntity;
import com.dog.usecase.auth.domain.Token;
import com.dog.usecase.auth.enums.TokenType;

public record TokenEntityToToken(TokenEntity tokenEntity) implements Token {
    @Override
    public Long id() {
        return tokenEntity.getId();
    }

    @Override
    public String jwt() {
        return tokenEntity.getJwt();
    }

    @Override
    public TokenType tokenType() {
        return tokenEntity.getTokenType();
    }

    @Override
    public boolean isRevoked() {
        return tokenEntity.isRevoked();
    }

    @Override
    public boolean isExpired() {
        return tokenEntity.isExpired();
    }

    @Override
    public Long idUser() {
        return tokenEntity.getUserEntity().getId();
    }
}
