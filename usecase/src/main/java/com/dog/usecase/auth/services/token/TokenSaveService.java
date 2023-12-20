package com.dog.usecase.auth.services.token;

import com.dog.usecase.auth.domain.Token;
import com.dog.usecase.auth.domain.User;
import com.dog.usecase.auth.enums.TokenType;
import lombok.RequiredArgsConstructor;

import java.util.function.BiConsumer;

@RequiredArgsConstructor
public final class TokenSaveService implements BiConsumer<User, String> {

    private final TokenService tokenService;

    @Override
    public void accept(User user, String jwt) {

        TokenWrapper tokenWrapper = new TokenWrapper(user, jwt);

        tokenService.save(tokenWrapper);
    }


    private record TokenWrapper(User user, String jwt) implements Token{

        @Override
        public Long id() {
            return null;
        }

        @Override
        public TokenType tokenType() {
            return TokenType.BEARER;
        }

        @Override
        public boolean isRevoked() {
            return false;
        }

        @Override
        public boolean isExpired() {
            return false;
        }

        @Override
        public Long idUser() {
            return user().id();
        }
    }

}
