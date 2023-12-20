package com.dog.usecase.auth.repository;


import com.dog.usecase.auth.domain.Token;

import java.util.List;
import java.util.Optional;

public interface TokenRepository {

    List<Token> findAllValidTokenByUser(Long id);

    Optional<Token> findByToken(String token);

    void update(Token token);

    Token save(Token token);
}
