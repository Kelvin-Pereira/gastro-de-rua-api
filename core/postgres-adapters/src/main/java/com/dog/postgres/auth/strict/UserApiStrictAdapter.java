package com.dog.postgres.auth.strict;

import com.dog.core.auth.domain.entity.User;
import com.dog.core.auth.domain.entity.UserRequest;
import com.dog.core.auth.strict.UserApiStrict;
import com.dog.postgres.auth.domain.entity.UserEntity;
import com.dog.postgres.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class UserApiStrictAdapter implements UserApiStrict.Port {

    private final UserRepository userRepository;
    @Override
    public User register(UserRequest user) {
        var userBuilder = UserEntity.builder()
                .name(user.getName())
                .email(user.getEmail().endereco())
                .birthDate(user.getBirthDate())
                .password(user.getPassword())
                .build();

        UserEntity userEntity = userRepository.save(userBuilder);

        return UserEntity.toUser(userEntity);
    }
}
