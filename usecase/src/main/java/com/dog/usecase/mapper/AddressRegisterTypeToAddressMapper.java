package com.dog.usecase.mapper;

import com.dog.usecase.auth.domain.Address;
import com.dog.usecase.type.auth.AddressRegisterType;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class AddressRegisterTypeToAddressMapper implements Address {

    private final AddressRegisterType input;

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
        return true;
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
