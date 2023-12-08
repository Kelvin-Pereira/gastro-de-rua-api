package com.dog.core.auth;

import com.dog.core.auth.domain.entity.Address;
import com.dog.core.auth.domain.entity.User;


public interface UserRegisterApi {

    User register(FormUserRegister user);

    record FormUserRegister(User user,
                            Address address) {
    }

}
