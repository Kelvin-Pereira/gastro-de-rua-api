package com.dog.arquitetura.brasil.internal;


import com.dog.arquitetura.brasil.Email;

public record EmailFromString(String endereco) implements Email {
    @Override
    public String toString() {
        return endereco;
    }
}
