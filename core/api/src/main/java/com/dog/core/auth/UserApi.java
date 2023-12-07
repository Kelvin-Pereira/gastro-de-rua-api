package com.dog.core.auth;

import com.dog.core.auth.domain.entity.User;
import com.dog.core.auth.domain.entity.UserRequest;


public interface UserApi {

    User register(UserRequest user);

}
