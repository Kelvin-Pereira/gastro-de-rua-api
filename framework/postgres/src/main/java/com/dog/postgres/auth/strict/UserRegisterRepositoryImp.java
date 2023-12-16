package com.dog.postgres.auth.strict;

import com.dog.postgres.auth.domain.entity.UserEntity;
import com.dog.postgres.auth.repository.UserRepositoryJpa;
import com.dog.postgres.mapper.UserEntityToUserMapper;
import com.dog.usecase.auth.domain.User;
import com.dog.usecase.auth.repository.UserRegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public final class UserRegisterRepositoryImp implements UserRegisterRepository {

    private final UserRepositoryJpa userRepositoryJpa;

    @Override
    public User register(User user) {

        UserEntity userEntity = new UserEntity(user);

        UserEntity userSaved = userRepositoryJpa.save(userEntity);

        return new UserEntityToUserMapper(userSaved);

    }
}
