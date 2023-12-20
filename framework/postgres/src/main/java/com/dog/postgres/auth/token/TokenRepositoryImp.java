package com.dog.postgres.auth.token;

import com.dog.postgres.auth.domain.entity.TokenEntity;
import com.dog.postgres.auth.repository.TokenRepositoryJpa;
import com.dog.postgres.mapper.TokenEntityToToken;
import com.dog.usecase.auth.domain.Token;
import com.dog.usecase.auth.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public final class TokenRepositoryImp implements TokenRepository {

    private final TokenRepositoryJpa tokenRepositoryJpa;

    @Override
    public List<Token> findAllValidTokenByUser(Long id) {
        List<TokenEntity> allValidTokenByUser = tokenRepositoryJpa.findAllValidTokenByUser(id);
        return allValidTokenByUser.stream().map(TokenEntityToToken::new).collect(Collectors.toList());
    }

    @Override
    public Optional<Token> findByToken(String token) {
        TokenEntity tokenEntity = tokenRepositoryJpa.findByJwt(token).orElseThrow();
        return Optional.of(new TokenEntityToToken(tokenEntity));
    }

    @Override
    public void update(Token token) {
        TokenEntity tokenEntity = new TokenEntity(token);
        tokenRepositoryJpa.save(tokenEntity);
    }

    @Override
    public Token save(Token token) {
        TokenEntity tokenEntity = new TokenEntity(token);
        return new TokenEntityToToken(tokenRepositoryJpa.save(tokenEntity));
    }
}
