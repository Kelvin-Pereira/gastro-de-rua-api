package com.dog.usecase.auth.perfil;

import com.dog.arquitetura.brasil.Cnpj;
import com.dog.usecase.auth.domain.User;

public sealed interface Perfil {

    record Sistema() implements Perfil {
    }

    record Usuario(User user) implements Perfil{}

    record Empresa(User user, Cnpj cnpj) implements Perfil{
    }

}
