package com.dog.postgres.mapper;

import com.dog.postgres.address.domain.entity.AddressEntity;
import com.dog.usecase.address.domain.Address;

import java.time.LocalDateTime;

public record AddressEntityToAddress(AddressEntity addressEntity) implements Address {
    @Override
    public Long id() {
        return addressEntity.getId();
    }

    @Override
    public String postalCode() {
        return addressEntity.getPostalCode();
    }

    @Override
    public String street() {
        return addressEntity.getStreet();
    }

    @Override
    public Integer number() {
        return addressEntity.getNumber();
    }

    @Override
    public String complement() {
        return addressEntity.getComplement();
    }

    @Override
    public String neighborhood() {
        return addressEntity.getNeighborhood();
    }

    @Override
    public String city() {
        return addressEntity.getCity();
    }

    @Override
    public String state() {
        return addressEntity.getState();
    }

    @Override
    public Boolean isPrimary() {
        return addressEntity.getIsPrimary();
    }
    @Override
    public Long idUser() {
        return addressEntity.getUserEntity().getId();
    }

    @Override
    public LocalDateTime createdAt() {
        return addressEntity.getCreatedAt();
    }

    @Override
    public LocalDateTime updatedAt() {
        return addressEntity.getCreatedAt();
    }
}
