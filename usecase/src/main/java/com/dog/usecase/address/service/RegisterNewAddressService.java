package com.dog.usecase.address.service;

import com.dog.usecase.address.domain.Address;
import com.dog.usecase.address.repository.AddressRegisterRepository;
import com.dog.usecase.auth.domain.User;
import com.dog.usecase.mapper.AddressRegisterTypeToAddressMapper;
import com.dog.usecase.type.address.AddressRegisterType;
import com.dog.usecase.type.address.AddressResponseType;
import lombok.RequiredArgsConstructor;

import java.util.function.BiFunction;

@RequiredArgsConstructor
public final class RegisterNewAddressService implements BiFunction<User, AddressRegisterType, AddressResponseType> {

    private final AddressRegisterRepository addressRegisterRepository;

    @Override
    public AddressResponseType apply(User usuario, AddressRegisterType addressRegisterType) {
        Address addressRegistered = addressRegisterRepository.register(new AddressRegisterTypeToAddressMapper(addressRegisterType, usuario));
        return new AddressResponseType(addressRegistered);
    }

}
