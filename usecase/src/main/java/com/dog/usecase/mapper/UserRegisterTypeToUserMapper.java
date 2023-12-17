package com.dog.usecase.mapper;

import com.dog.usecase.auth.domain.Address;
import com.dog.usecase.auth.domain.Token;
import com.dog.usecase.auth.domain.User;
import com.dog.usecase.auth.enums.Permission;
import com.dog.usecase.type.auth.UserRegisterType;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class UserRegisterTypeToUserMapper implements User {
    private final UserRegisterType input;
    private final Permission role;

    @Override
    public Long id() {
        return null;
    }

    @Override
    public String name() {
        return input.getName();
    }

    @Override
    public String email() {
        return input.getEmail();
    }

    @Override
    public LocalDate birthDate() {
        return input.getBirthDate();
    }

    @Override
    public String urlPhoto() {
        return null;
    }

    @Override
    public String phone() {
        return input.getPhone();
    }

    @Override
    public Permission role() {
        return role;
    }

    @Override
    public String password() {
        return input.getPassword();
    }

    @Override
    public List<Token> tokens() {
        return Collections.emptyList();
    }

    @Override
    public List<Address> address() {
        Address enderecosMapeados = new AddressRegisterTypeToAddressMapper(input.getAddress());
        return Collections.singletonList(enderecosMapeados);
    }

    @Override
    public LocalDateTime createdAt() {
        return null;
    }

    @Override
    public LocalDateTime updatedAt() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
