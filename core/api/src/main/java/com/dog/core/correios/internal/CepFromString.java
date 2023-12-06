package com.dog.core.correios.internal;


import com.dog.core.correios.Cep;

public record CepFromString(String digitos) implements Cep {
    @Override
    public String toString() {
        return formatado();
    }
}
