package com.dog.postgres.auth.token;

import com.dog.core.auth.TokenApi;
import com.dog.core.auth.domain.entity.Token;
import com.dog.postgres.auth.domain.entity.TokenEntity;
import com.dog.postgres.auth.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public final class TokenApiStrictAdapter implements TokenApi {

    private final TokenRepository tokenRepository;

    @Override
    public List<Token> findAllValidTokenByUser(Long id) {
        List<TokenEntity> allValidTokenByUser = tokenRepository.findAllValidTokenByUser(id);

        return List.of();
    }

    @Override
    public Optional<Token> findByToken(String token) {

        //tratar error
        TokenEntity tokenEntity = tokenRepository.findByToken(token).orElseThrow();

        return Optional.empty();
    }

    @Override
    public void update(Token token) {

        tokenRepository.save(new TokenEntity());
    }
}
