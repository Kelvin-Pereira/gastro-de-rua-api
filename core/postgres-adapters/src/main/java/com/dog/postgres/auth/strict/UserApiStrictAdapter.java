package com.dog.postgres.auth.strict;

import com.dog.core.auth.domain.entity.User;
import com.dog.core.auth.domain.entity.UserRegisterRequest;
import com.dog.core.auth.strict.UserApiStrict;
import com.dog.postgres.auth.domain.entity.UserEntity;
import com.dog.postgres.auth.domain.mapper.UserMapper;
import com.dog.postgres.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class UserApiStrictAdapter implements UserApiStrict.Port {

    private final UserRepository userRepository;
    @Override
    public User register(UserRegisterRequest userRegisterRequest) {

        UserEntity userEntity = userRepository.save(UserMapper.toUserEntity(userRegisterRequest));

        return UserMapper.toUser(userEntity);
    }
}
