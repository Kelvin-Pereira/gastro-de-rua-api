package com.dog.postgres.auth.token;

import com.dog.core.auth.domain.entity.Token;
import com.dog.core.auth.token.TokenApiStrict;
import com.dog.postgres.auth.domain.entity.TokenEntity;
import com.dog.postgres.auth.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TokenApiStrictAdapter implements TokenApiStrict.Port {

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
