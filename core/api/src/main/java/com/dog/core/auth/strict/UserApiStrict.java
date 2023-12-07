package com.dog.core.auth.strict;

import com.dog.core.auth.UserApi;
import com.dog.core.auth.domain.entity.User;
import com.dog.core.auth.domain.entity.UserRegisterRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserApiStrict implements UserApi {

    private final UserApiStrict.Port userStrictAdapter;
    @Override
    public User register(UserRegisterRequest user) {
        return userStrictAdapter.register(user);
    }


    public interface Port {
        User register(UserRegisterRequest user);
    }
}
