package com.dog.usecase.auth.services;

import com.dog.usecase.auth.domain.Address;
import com.dog.usecase.auth.domain.Token;
import com.dog.usecase.auth.domain.User;
import com.dog.usecase.auth.enums.Permission;
import com.dog.usecase.auth.repository.UserRegisterRepository;
import com.dog.usecase.auth.services.token.CryptoPasswordService;
import com.dog.usecase.type.auth.TokenResponseType;
import com.dog.usecase.type.auth.UserRegisterType;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

@RequiredArgsConstructor
public final class RegistrarUsuarioService implements Function<UserRegisterType, TokenResponseType> {

    private final UserRegisterRepository userRegisterRepository;
    private final CryptoPasswordService cryptoPassWordService;

    @Override
    public TokenResponseType apply(UserRegisterType input) {
        cryptoPassword(input);


        User user = userRegisterRepository.register(new UserEntity(input));

        System.out.println(user.role());


        return new TokenResponseType();
    }

    private void cryptoPassword(UserRegisterType input){
        input.setPassword(cryptoPassWordService.apply(input.getPassword()));
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
