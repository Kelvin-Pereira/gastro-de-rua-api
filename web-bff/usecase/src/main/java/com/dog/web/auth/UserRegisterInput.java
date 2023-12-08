package com.dog.web.auth;

import com.dog.core.auth.UserRegisterApi;
import com.dog.core.auth.domain.entity.Address;
import com.dog.core.auth.domain.entity.User;
import com.dog.web.type.InputType;

public record UserRegisterInput(User user, Address address) implements InputType {

    public UserRegisterApi.FormUserRegister toForm(User user, Address address) {
        return new UserRegisterApi.FormUserRegister(user, address);
    }

}
