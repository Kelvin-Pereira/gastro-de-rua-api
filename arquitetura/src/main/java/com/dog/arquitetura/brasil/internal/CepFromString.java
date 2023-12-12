package com.dog.arquitetura.brasil.internal;


import com.dog.arquitetura.brasil.Cep;

public record CepFromString(String digitos) implements Cep {
    @Override
    public String toString() {
        return formatado();
    }
}
