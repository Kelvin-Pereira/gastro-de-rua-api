package com.dog.arquitetura.brasil.internal;


import com.dog.arquitetura.brasil.Telefone;

public record TelefoneFromString(String digitos) implements Telefone {
    @Override
    public String toString() {
        return digitos;
    }
}
