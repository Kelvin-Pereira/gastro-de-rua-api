package com.dog.web.auth;

import com.dog.core.auth.UserRegisterApi;
import com.dog.core.auth.domain.entity.TokenResponse;
import com.dog.core.auth.domain.entity.User;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
public final class UcRegistrarUsuario implements Function<UserRegisterInput, TokenResponse> {

    private final UserRegisterApi userRegisterApi;

    private static final String CUSTOMER = "CUSTOMER";

    @Override
    public TokenResponse apply(UserRegisterInput input) {

        User user = userRegisterApi.register(input.toForm(input.user(), input.address()));

        System.out.println(user.name());

        return new TokenResponse();
    }

}
