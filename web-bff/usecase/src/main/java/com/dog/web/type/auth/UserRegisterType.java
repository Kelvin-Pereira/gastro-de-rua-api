package com.dog.web.type.auth;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.function.UnaryOperator;

@Getter
@Setter
public class UserRegisterType extends UserType {

    private AddressRegisterType address;

    public UserRegisterType(@NonNull UnaryOperator<String> crypt) {
        setPassword(crypt.apply(getPassword()));
        emailRequerido(getEmail());
        telefoneRequerido(getPhone());
    }

}
