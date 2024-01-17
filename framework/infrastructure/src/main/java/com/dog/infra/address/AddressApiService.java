package com.dog.infra.address;

import com.dog.usecase.address.repository.SeachAddressByCepRepository;
import com.dog.usecase.address.type.AddressByCepType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressApiService implements SeachAddressByCepRepository {

    private final AddressSeachRepository addressSeachRepository;

    @Override
    public AddressByCepType seachAddressByCep(String cep) {
        return addressSeachRepository.seachAddressByCep(cep);
    }
}
