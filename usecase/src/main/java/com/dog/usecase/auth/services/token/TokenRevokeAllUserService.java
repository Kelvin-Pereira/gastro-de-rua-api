package com.dog.usecase.auth.services.token;

import com.dog.usecase.auth.domain.Token;
import com.dog.usecase.auth.domain.User;
import com.dog.usecase.auth.enums.TokenType;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public final class TokenRevokeAllUserService implements Consumer<User> {

    private final TokenService service;

    @Override
    public void accept(User user) {

        List<Token> allValidTokenByUser = service.findAllValidTokenByUser(user.id());

        if (allValidTokenByUser.isEmpty())
            return;

        List<TokenMapper> collected = allValidTokenByUser.stream().map(TokenMapper::new).toList();

        collected.forEach(service::update);
    }

    private record TokenMapper(Token token) implements Token {

        @Override
        public Long id() {
            return token.id();
        }

        @Override
        public String jwt() {
            return token.jwt();
        }

        @Override
        public TokenType tokenType() {
            return token.tokenType();
        }

        @Override
        public boolean isRevoked() {
            return true;
        }

        @Override
        public boolean isExpired() {
            return true;
        }

        @Override
        public Long idUser() {
            return token.idUser();
        }
    }
}
