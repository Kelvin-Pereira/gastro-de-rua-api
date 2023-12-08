package com.dog.core.auth;

import com.dog.core.auth.domain.entity.Token;

import java.util.List;
import java.util.Optional;

public interface TokenApi {

    // TODO implemntar
    List<Token> findAllValidTokenByUser(Long id);

    Optional<Token> findByToken(String token);

    void update(Token token);

}
