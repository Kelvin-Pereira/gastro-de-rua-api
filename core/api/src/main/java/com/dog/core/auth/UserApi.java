package com.dog.core.auth;

import com.dog.arquitetura.brasil.Email;
import com.dog.arquitetura.brasil.Telefone;

import java.time.LocalDate;
import java.util.Optional;

public interface UserApi {

    Optional<TokenUser> register(Usuario user);


    record Usuario(String name,
                Email email,
                LocalDate birthDate,
                Telefone telefone,
                String password) {

    }


}
