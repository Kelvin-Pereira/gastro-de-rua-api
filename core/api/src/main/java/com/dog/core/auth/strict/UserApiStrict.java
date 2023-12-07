package com.dog.core.auth.strict;

import com.dog.core.auth.UserApi;
import com.dog.core.auth.domain.entity.User;
import com.dog.core.auth.domain.entity.UserRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserApiStrict implements UserApi {

    private final UserApiStrict.Port port;
    @Override
    public User register(UserRequest user) {
        return port.register(user);
    }


    public interface Port {
        User register(UserRequest user);
    }
}
