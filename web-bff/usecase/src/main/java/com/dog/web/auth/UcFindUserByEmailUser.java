package com.dog.web.auth;

import com.dog.core.auth.UserApi;
import com.dog.core.auth.domain.entity.User;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
public final class UcFindUserByEmailUser implements Function<String, Optional<User>> {

    private final UserApi userApi;

    @Override
    public Optional<User> apply(String email) {
        return userApi.findByEmail(email);
    }

}
