package com.dog.postgres.auth.strict;

import com.dog.core.auth.UserRegisterApi;
import com.dog.core.auth.domain.entity.User;
import com.dog.postgres.auth.domain.entity.UserEntity;
import com.dog.postgres.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public final class UserRegisterApiStrictAdapter implements UserRegisterApi {

    private final UserRepository userRepository;

    @Override
    public User register(User user) {

        UserEntity userEntity = new UserEntity(user);
               return  (User) userRepository.save(userEntity);

    }
}
