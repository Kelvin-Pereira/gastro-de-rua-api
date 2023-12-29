package com.dog.infra.endereco.correios.strict;


import com.dog.arquitetura.brasil.Cep;
import com.dog.arquitetura.lang.annotation.Nullable;
import com.dog.infra.endereco.correios.Endereco;
import com.dog.infra.endereco.ibge.Municipio;

import java.util.Optional;

public record EnderecoStrict(Cep cep,
                             String logradouro,
                             String bairro,
                             String numero,
                             @Nullable String complementoOpt,
                             Municipio municipio,
                             @Nullable String distritoOpt,
                             boolean modificado) implements Endereco {

    @Override
    public Optional<String> complemento() {
        return Optional.ofNullable(complementoOpt);
    }

    @Override
    public Optional<String> distrito() {
        return Optional.ofNullable(distritoOpt);
    }
}
