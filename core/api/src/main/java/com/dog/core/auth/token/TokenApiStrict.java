package com.dog.core.auth.token;

import com.dog.core.auth.TokenApi;
import com.dog.core.auth.domain.entity.Token;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
public final class TokenApiStrict implements TokenApi {

    private final TokenApiStrict.Port strictAdapter;

    @Override
    public List<Token> findAllValidTokenByUser(Long id) {
        return List.of();
    }

    @Override
    public Optional<Token> findByToken(String token) {
        return Optional.empty();
    }

    @Override
    public void update(Token token) {
        strictAdapter.update(token);
    }

    public interface Port {
        List<Token> findAllValidTokenByUser(Long id);

        Optional<Token> findByToken(String token);

        void update(Token token);

    }

}
