package com.dog.postgres.auth.strict;

import com.dog.core.auth.UserApi;
import com.dog.core.auth.domain.entity.User;
import com.dog.postgres.auth.domain.entity.UserEntity;
import com.dog.postgres.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public final class UserApiStrictAdapter implements UserApi {

    private final UserRepository userRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserEntity> byEmail = userRepository.findByEmail(email);
        return Optional.empty();
    }
}
