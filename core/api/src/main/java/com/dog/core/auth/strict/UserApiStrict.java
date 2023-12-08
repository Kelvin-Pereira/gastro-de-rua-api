package com.dog.core.auth.strict;

import com.dog.core.auth.UserApi;
import com.dog.core.auth.domain.entity.User;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public final class UserApiStrict implements UserApi {

    private final UserApiStrict.Port strictAdapter;

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> byEmail = strictAdapter.findByEmail(email);
        return Optional.empty();
    }

    public interface Port {
        Optional<User> findByEmail(String email);
    }

}
