package com.dog.core.auth.strict;

import com.dog.core.auth.UserRegisterApi;
import com.dog.core.auth.domain.entity.Address;
import com.dog.core.auth.domain.entity.Token;
import com.dog.core.auth.domain.entity.User;
import com.dog.core.auth.internal.UserObject;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public final class UserRegisterApiStrict implements UserRegisterApi {

    private final UserRegisterApiStrict.Port userStrictAdapter;
    @Override
    public User register(FormUserRegister form) {
        return userStrictAdapter.register(new UserStrict(form));
    }

    public interface Port {
        User register(User user);
    }

    @RequiredArgsConstructor
    private static class UserStrict extends UserObject {
        private final FormUserRegister form;

        @Override
        public String name() {
            return form.user().name();
        }

        @Override
        public String email() {
            return form.user().email();
        }

        @Override
        public LocalDate birthDate() {
            return form.user().birthDate();
        }

        @Override
        public String urlPhoto() {
            return form.user().urlPhoto();
        }

        @Override
        public String phone() {
            return form.user().phone();
        }

        @Override
        public String role() {
            return form.user().role();
        }

        @Override
        public String password() {
            return form.user().password();
        }

        @Override
        public List<Token> tokens() {
            return List.of();
        }

        @Override
        public List<Address> address() {
            return form.user().address();
        }
    }

}
