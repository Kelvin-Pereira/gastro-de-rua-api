package com.dog.postgres.mapper;

import com.dog.postgres.auth.domain.entity.UserEntity;
import com.dog.usecase.auth.domain.Address;
import com.dog.usecase.auth.domain.Token;
import com.dog.usecase.auth.domain.User;
import com.dog.usecase.auth.enums.Permission;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record UserEntityToUserMapper(UserEntity userEntity) implements User {

    @Override
    public Long id() {
        return userEntity.getId();
    }

    @Override
    public String name() {
        return userEntity.getName();
    }

    @Override
    public String email() {
        return userEntity.getEmail();
    }

    @Override
    public LocalDate birthDate() {
        return userEntity.getBirthDate();
    }

    @Override
    public String urlPhoto() {
        return userEntity.getUrlPhoto();
    }

    @Override
    public String phone() {
        return userEntity.getPhone();
    }

    @Override
    public Permission role() {
        return userEntity.getRole();
    }

    @Override
    public String password() {
        return userEntity.getPassword();
    }

    @Override
    public List<Token> tokens() {
        return null; // Todo criar Mapper
    }

    @Override
    public List<Address> address() {
        return userEntity.getAddressEntities().stream().map(AddressEntityToAddress::new).collect(Collectors.toList());
    }

    @Override
    public LocalDateTime createdAt() {
        return userEntity.getCreatedAt();
    }

    @Override
    public LocalDateTime updatedAt() {
        return userEntity.getUpdatedAt();
    }

    @Override
    public boolean isAccountNonExpired() {
        return userEntity.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return userEntity.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return userEntity.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return userEntity.isEnabled();
    }
}
