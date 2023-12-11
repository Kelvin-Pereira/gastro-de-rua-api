package com.dog.core.auth.domain.entity;


import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public interface User {

    Long id();

    String name();

    String email();

    LocalDate birthDate();

    String urlPhoto();

    String phone();

    String role();

    String password();

    List<Token> tokens();

    List<Address> address();

    default Address getAddressPrincipal() {
        Optional<Address> optionalAddress = address()
                .stream()
                .filter(Address::isPrimary)
                .findFirst();
        return optionalAddress.orElse(null);
    }

    default String getPassword(UnaryOperator<String> cryptPassword){
        return cryptPassword.apply(password());
    }

}
