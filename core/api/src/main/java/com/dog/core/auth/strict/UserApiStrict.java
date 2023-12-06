package com.dog.core.auth.strict;

import com.dog.core.auth.TokenUser;
import com.dog.core.auth.UserApi;
import com.dog.core.auth.domain.entity.User;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public final class UserApiStrict implements UserApi {
    private final UserApiStrict.Port port;
    @Override
    public Optional<TokenUser> register(Usuario user) {

        User register = port.register(user);

        return null;
    }


    public interface Port {
        User register(Usuario user);

    }
}
