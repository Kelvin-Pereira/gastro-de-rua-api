package com.dog.postgres.auth.strict;

import com.dog.postgres.auth.domain.entity.UserEntity;
import com.dog.postgres.auth.repository.UserRepositoryJpa;
import com.dog.postgres.mapper.UserEntityToUserMapper;
import com.dog.usecase.auth.domain.User;
import com.dog.usecase.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public final class UserRepositoryImp implements UserRepository {

    private final UserRepositoryJpa userRepositoryJpa;

    @Override
    public Optional<User> findByEmail(String email) {
        // TODO tratar lancamento de erros
        UserEntity userEntity = userRepositoryJpa.findByEmail(email).orElseThrow();
        return Optional.of(new UserEntityToUserMapper(userEntity));
    }
}
