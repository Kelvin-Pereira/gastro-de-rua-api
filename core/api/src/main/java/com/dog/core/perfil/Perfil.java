package com.dog.core.perfil;

import com.dog.arquitetura.brasil.Cnpj;

public sealed interface Perfil {

    record Sistema() implements Perfil {
    }

    record Cliente(Usuario usuario) implements Perfil{
    }

    record Empresa(Usuario usuario, Cnpj empresa) implements Perfil{
    }


}
