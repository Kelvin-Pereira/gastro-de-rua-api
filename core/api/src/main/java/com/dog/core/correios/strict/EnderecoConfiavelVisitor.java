package com.dog.core.correios.strict;


import com.dog.arquitetura.lang.annotation.Nullable;
import com.dog.core.correios.Endereco;
import com.dog.core.correios.Logradouro;
import com.dog.core.correios.LogradouroVisitor;
import com.dog.core.ibge.Municipio;

import java.util.function.Function;

record EnderecoConfiavelVisitor(Function<Municipio, String> distritoValido,
                                String logradouro,
                                String numero,
                                String bairro,
                                @Nullable String complemento) implements LogradouroVisitor<Endereco> {

    @Override
    public Endereco visit(Logradouro.FaixaDeUf faixaDeUf) {
        throw new IllegalArgumentException("FAIXA_DE_UF_NAO_SUPORTADA");
    }

    @Override
    public Endereco visit(Logradouro.FaixaDeMunicipio faixaDeMunicipio) {
        Municipio municipio = faixaDeMunicipio.municipio();
        return new EnderecoStrict(faixaDeMunicipio.cep(),
                logradouro,
                bairro,
                numero,
                complemento,
                municipio,
                distritoValido.apply(municipio),
                false);
    }

    @Override
    public Endereco visit(Logradouro.FaixaDeBairro faixaDeBairro) {
        Municipio municipio = faixaDeBairro.municipio();
        return new EnderecoStrict(faixaDeBairro.cep(),
                logradouro,
                faixaDeBairro.bairro(),
                numero,
                complemento,
                municipio,
                distritoValido.apply(municipio),
                false);
    }

    @Override
    public Endereco visit(Logradouro.Completo completo) {
        Municipio municipio = completo.municipio();
        return new EnderecoStrict(completo.cep(),
                completo.logradouro(),
                completo.bairro(),
                numero,
                complemento,
                municipio,
                distritoValido.apply(municipio),
                false);
    }

}
