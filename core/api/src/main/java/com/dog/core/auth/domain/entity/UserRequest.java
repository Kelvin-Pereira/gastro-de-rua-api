package com.dog.core.auth.domain.entity;


import com.dog.arquitetura.brasil.Email;
import com.dog.arquitetura.brasil.Telefone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String name;
    private Email email;
    private LocalDate birthDate;
    private String password;
    private Telefone phone;
    private AddressRequest address;

}
