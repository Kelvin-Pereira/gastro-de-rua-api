package com.dog.postgres.address.strict;

import com.dog.arquitetura.DomainException;
import com.dog.postgres.address.domain.entity.AddressEntity;
import com.dog.postgres.address.repository.AddressRepositoryJpa;
import com.dog.postgres.auth.domain.entity.UserEntity;
import com.dog.postgres.auth.repository.UserRepositoryJpa;
import com.dog.postgres.mapper.AddressEntityToAddress;
import com.dog.usecase.address.domain.Address;
import com.dog.usecase.address.repository.AddressRegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class RegisterAddressRepositoryImp implements AddressRegisterRepository {

    private static final int LIMIT_ADDRESS = 3;

    private final AddressRepositoryJpa addressRepositoryJpa;
    private final UserRepositoryJpa userRepositoryJpa;

    @Override
    @Transactional
    public Address register(Address address) {

        UserEntity userEntity = userRepositoryJpa.findById(address.idUser()).orElseThrow();

        if(userEntity.getAddressEntities().size() >= LIMIT_ADDRESS){
            throw new DomainException("402");
        }

        AddressEntity addressEntity = new AddressEntity(address, userEntity);
        AddressEntity addressSaved = addressRepositoryJpa.save(addressEntity);
        return new AddressEntityToAddress(addressSaved);
    }
}
