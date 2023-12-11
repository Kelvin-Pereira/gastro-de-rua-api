package com.dog.web.auth.token;

import com.dog.core.auth.TokenApi;
import com.dog.core.auth.domain.entity.Token;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public final class UcToken implements TokenApi {

    private final TokenApi tokenApi;

    @Override
    public List<Token> findAllValidTokenByUser(Long id) {

        List<Token> allValidTokenByUser = tokenApi.findAllValidTokenByUser(id);

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
