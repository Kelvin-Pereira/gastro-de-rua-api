package com.dog.infra.address;

import com.dog.usecase.address.type.AddressByCepType;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Seach Address By CEP", value = "https://viacep.com.br/ws")
public interface AddressSeachRepository {

    @GetMapping("/{cep}")
    AddressByCepType seachAddressByCep(@PathVariable String cep);

}
