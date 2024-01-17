package com.dog.usecase.address.repository;

import com.dog.usecase.address.type.AddressByCepType;

public interface SeachAddressByCepRepository {

    AddressByCepType seachAddressByCep(String cep);

}
