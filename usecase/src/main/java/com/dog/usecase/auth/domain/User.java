package com.dog.usecase.auth.domain;


import com.dog.usecase.auth.enums.Permission;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface User {

    Long id();
    String name();
    String email();
    LocalDate birthDate();
    String urlPhoto();
    String phone();
    Permission role();
    String password();
    List<Token> tokens();
    List<Address> address();
    LocalDateTime createdAt();
    LocalDateTime updatedAt();
    boolean isAccountNonExpired();
    boolean isAccountNonLocked();
    boolean isCredentialsNonExpired();
    boolean isEnabled();
    default Address getAddressPrincipal() {
        Optional<Address> optionalAddress = address()
                .stream()
                .filter(Address::isPrimary)
                .findFirst();
        return optionalAddress.orElse(null);
    }

}
