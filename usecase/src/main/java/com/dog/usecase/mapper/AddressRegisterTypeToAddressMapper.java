package com.dog.usecase.mapper;

import com.dog.usecase.address.domain.Address;
import com.dog.usecase.auth.domain.User;
import com.dog.usecase.type.address.AddressRegisterType;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.management.ConstructorParameters;
import java.time.LocalDateTime;

public record AddressRegisterTypeToAddressMapper(AddressRegisterType input, User user) implements Address {

    @Override
    public Long id() {
        return null;
    }

    @Override
    public String postalCode() {
        return input.getPostalCode();
    }

    @Override
    public String street() {
        return input.getStreet();
    }

    @Override
    public Integer number() {
        return input.getNumber();
    }

    @Override
    public String complement() {
        return input.getComplement();
    }

    @Override
    public String neighborhood() {
        return input.getNeighborhood();
    }

    @Override
    public String city() {
        return input.getCity();
    }

    @Override
    public String state() {
        return input.getState();
    }

    @Override
    public Boolean isPrimary() {
        return input.getIsPrimary();
    }

    @Override
    public Long idUser() {
        return user.id();
    }

    @Override
    public LocalDateTime createdAt() {
        return null;
    }

    @Override
    public LocalDateTime updatedAt() {
        return null;
    }
}
