package com.dog.postgres.auth.strict;

import com.dog.core.auth.UserApi;
import com.dog.core.auth.domain.entity.User;
import com.dog.core.auth.strict.UserApiStrict;
import com.dog.postgres.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class UserApiStrictAdapter implements UserApiStrict.Port {

    private final UserRepository userRepository;
    @Override
    public User register(UserApi.Usuario user) {
        var userBuilder = User.builder()
                .name(user.name())
                .email(user.email().endereco())
                .birthDate(user.birthDate())
                .password(user.password())
                .build();

        return userRepository.save(userBuilder);
    }
}
