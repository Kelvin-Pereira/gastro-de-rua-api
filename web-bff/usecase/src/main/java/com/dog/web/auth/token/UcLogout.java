package com.dog.web.auth.token;

import com.dog.core.auth.TokenApi;
import com.dog.core.auth.domain.entity.Token;
import com.dog.core.auth.domain.enums.TokenType;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

@RequiredArgsConstructor
public final class UcLogout implements Consumer<String> {

    private final UcToken ucToken;

    // Todo tratar orElseThrow
    @Override
    public void accept(String token) {
        Token byToken = ucToken.findByToken(token).orElseThrow();
        ucToken.update(new Logout(byToken));
    }

    public record Logout(Token byToken) implements Token {
        @Override
        public Long id() {
            return byToken.id();
        }

        @Override
        public String token() {
            return byToken.token();
        }

        @Override
        public TokenType tokenType() {
            return byToken.tokenType();
        }

        @Override
        public boolean isRevoked() {
            return true;
        }

        @Override
        public boolean isExpired() {
            return true;
        }
    }

}
