package com.dog.core.auth;

import com.dog.core.auth.domain.entity.User;

import java.util.Optional;


public interface UserApi {

    // TODO implemantar
    Optional<User> findByEmail(String email);


}
