package com.dog.web.boot.address.config;

import com.dog.usecase.address.repository.AddressRegisterRepository;
import com.dog.usecase.address.service.RegisterNewAddressService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class AddressConfigurationsBeans {

    @Bean
    RegisterNewAddressService registerNewAddressService(AddressRegisterRepository addressRegisterRepository){
        return new RegisterNewAddressService(addressRegisterRepository);
    }

}
