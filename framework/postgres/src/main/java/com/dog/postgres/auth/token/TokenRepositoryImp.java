package com.dog.postgres.auth.token;

import com.dog.postgres.auth.domain.entity.TokenEntity;
import com.dog.postgres.auth.repository.TokenRepositoryJpa;
import com.dog.usecase.auth.domain.Token;
import com.dog.usecase.auth.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public final class TokenRepositoryImp implements TokenRepository {

    private final TokenRepositoryJpa tokenRepositoryJpa;

    @Override
    public List<Token> findAllValidTokenByUser(Long id) {
        List<TokenEntity> allValidTokenByUser = tokenRepositoryJpa.findAllValidTokenByUser(id);

        return List.of();
    }

    @Override
    public Optional<Token> findByToken(String token) {

        //tratar error
        TokenEntity tokenEntity = tokenRepositoryJpa.findByToken(token).orElseThrow();

        return Optional.empty();
    }

    @Override
    public void update(Token token) {

        tokenRepositoryJpa.save(new TokenEntity());
    }
}
