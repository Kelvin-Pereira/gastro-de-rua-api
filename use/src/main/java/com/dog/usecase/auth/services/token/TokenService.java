package com.dog.usecase.auth.services.token;

import com.dog.usecase.auth.domain.Token;
import com.dog.usecase.auth.repository.TokenRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public final class TokenService implements TokenRepository {

    private final TokenRepository tokenRepository;

    @Override
    public List<Token> findAllValidTokenByUser(Long id) {

        List<Token> allValidTokenByUser = tokenRepository.findAllValidTokenByUser(id);

        return null;
    }

    @Override
    public Optional<Token> findByToken(String token) {
        return Optional.empty();
    }

    @Override
    public void update(Token token) {

    }
}
