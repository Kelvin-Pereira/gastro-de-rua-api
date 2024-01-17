package com.dog.usecase.address.service;

import com.dog.usecase.address.repository.SeachAddressByCepRepository;
import com.dog.usecase.address.type.AddressByCepType;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
public class SeachAddressByCepService implements Function<String, AddressByCepType> {

    private final SeachAddressByCepRepository seachAddressByCepRepository;

    @Override
    public AddressByCepType apply(String cep) {
        return seachAddressByCepRepository.seachAddressByCep(cep);
    }
}
