package com.dog.usecase.auth.services;

import com.dog.usecase.auth.domain.User;
import com.dog.usecase.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
public final class FindUserByEmailUserService implements Function<String, Optional<User>> {

    private final UserRepository userRepository;

    @Override
    public Optional<User> apply(String email) {
        return userRepository.findByEmail(email);
    }

}
