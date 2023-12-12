package com.dog.web.auth;

import com.dog.core.auth.UserRegisterApi;
import com.dog.core.auth.domain.entity.Address;
import com.dog.core.auth.domain.entity.Token;
import com.dog.core.auth.domain.entity.TokenResponse;
import com.dog.core.auth.domain.entity.User;
import com.dog.core.auth.domain.enums.Permission;
import com.dog.web.auth.token.UcCryptoPassword;
import com.dog.web.type.auth.UserRegisterType;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

@RequiredArgsConstructor
public final class UcRegistrarUsuario implements Function<UserRegisterType, TokenResponse> {

    private final UserRegisterApi userRegisterApi;
    private final UcCryptoPassword ucCryptoPassWord;

    @Override
    public TokenResponse apply(UserRegisterType input) {
        cryptoPassword(input);


        User user = userRegisterApi.register(new UserEntity(input));

        System.out.println(user.role());


        return new TokenResponse();
    }

    private void cryptoPassword(UserRegisterType input){
        input.setPassword(ucCryptoPassWord.apply(input.getPassword()));
    }

    @RequiredArgsConstructor
    public static class UserEntity implements User{
        private final UserRegisterType input;

        @Override
        public Long id() {
            return null;
        }

        @Override
        public String name() {
            return input.getName();
        }

        @Override
        public String email() {
            return input.getEmail();
        }

        @Override
        public LocalDate birthDate() {
            return input.getBirthDate();
        }

        @Override
        public String urlPhoto() {
            return null;
        }

        @Override
        public String phone() {
            return input.getPhone();
        }

        @Override
        public Permission role() {
            return null;
        }

        @Override
        public String password() {
            return input.getPassword();
        }

        @Override
        public List<Token> tokens() {
            return null;
        }

        @Override
        public List<Address> address() {
            return null;
        }
    }


}
