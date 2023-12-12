package com.dog.usecase.auth.repository;


import com.dog.usecase.auth.domain.User;

public interface UserRegisterRepository {

    User register(User user);

}
