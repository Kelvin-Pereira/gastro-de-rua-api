package com.dog.usecase.auth.repository;


import com.dog.usecase.auth.domain.User;

import java.util.Optional;


public interface UserRepository {

    Optional<User> findByEmail(String email);

}
