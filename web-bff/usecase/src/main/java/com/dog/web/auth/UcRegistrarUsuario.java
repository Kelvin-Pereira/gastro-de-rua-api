package com.dog.web.auth;

import com.dog.core.auth.UserRegisterApi;
import com.dog.core.auth.domain.entity.TokenResponse;
import com.dog.core.auth.domain.entity.User;
import com.dog.web.auth.token.UcCryptoToken;
import com.dog.web.type.auth.AddressRegisterType;
import com.dog.web.type.auth.UserRegisterType;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
public final class UcRegistrarUsuario implements Function<UcRegistrarUsuario.Input, TokenResponse> {

    private final UserRegisterApi userRegisterApi;
    private final UcCryptoToken ucCryptoToken;

    private static final String CUSTOMER = "CUSTOMER";

    @Override
    public TokenResponse apply(Input input) {

        input.userRegisterType.setPassword(ucCryptoToken.apply(input.userRegisterType.getPassword()));


        User user = userRegisterApi.register((User) new Object());

        System.out.println(user.name());

        return new TokenResponse();
    }

    public record Input(UserRegisterType userRegisterType, AddressRegisterType addressRegisterType){
    }


}
