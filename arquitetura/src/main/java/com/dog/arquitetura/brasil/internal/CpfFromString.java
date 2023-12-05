package com.dog.arquitetura.brasil.internal;


import com.dog.arquitetura.brasil.Cpf;

public record CpfFromString(String digitos) implements Cpf {
    @Override
    public String toString() {
        return digitos;
    }
}
