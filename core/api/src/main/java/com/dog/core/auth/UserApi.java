package com.dog.core.auth;

import com.dog.core.auth.domain.entity.User;
import com.dog.core.auth.domain.entity.UserRegisterRequest;


public interface UserApi {

    User register(UserRegisterRequest user);

}
