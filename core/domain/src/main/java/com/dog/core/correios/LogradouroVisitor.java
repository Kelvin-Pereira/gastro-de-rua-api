package com.dog.core.correios;

public interface LogradouroVisitor<T> {

    T visit(Logradouro.FaixaDeUf faixaDeUf);

    T visit(Logradouro.FaixaDeMunicipio faixaDeMunicipio);

    T visit(Logradouro.FaixaDeBairro faixaDeBairro);

    T visit(Logradouro.Completo completo);
}
