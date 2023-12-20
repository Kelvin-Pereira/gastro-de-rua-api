package com.dog.usecase.auth.services.token;

import com.dog.usecase.auth.domain.Token;
import com.dog.usecase.auth.enums.TokenType;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

@RequiredArgsConstructor
public final class LogoutService implements Consumer<String> {

    private final TokenService tokenService;

    // Todo tratar orElseThrow
    @Override
    public void accept(String token) {
        Token byToken = tokenService.findByToken(token).orElseThrow();
        tokenService.update(new Logout(byToken));
    }


    // TODO criar mapper
    public record Logout(Token byToken) implements Token {
        @Override
        public Long id() {
            return byToken.id();
        }

        @Override
        public String jwt() {
            return byToken.jwt();
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

        @Override
        public Long idUser() {
            return byToken.idUser();
        }
    }

}
