package com.dog.core.auth;

import com.dog.arquitetura.brasil.Email;
import com.dog.arquitetura.brasil.Telefone;

import java.time.LocalDate;

public interface UserApi {

    TokenUser register(User user);


    record User(String name,
                Email email,
                LocalDate birthDate,
                Telefone telefone,
                String password) {

    }


}
