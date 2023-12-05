package com.dog.arquitetura.brasil.internal;


import com.dog.arquitetura.brasil.Cnpj;

public record CnpjFromString(String digitos) implements Cnpj {
    @Override
    public String toString() {
        return digitos;
    }
}
