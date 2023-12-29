package com.dog.usecase.address.repository;

import com.dog.usecase.address.domain.Address;

public interface AddressRegisterRepository {

    Address register(Address address);

}
