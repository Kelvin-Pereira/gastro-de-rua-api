package com.dog.core.correios;

import com.dog.arquitetura.lang.annotation.Nullable;

import java.util.Optional;

public interface EnderecoApi extends LogradouroSearchApi {

    Optional<Endereco> enderecoConfiavel(Cep cep,
                                         String logradouro,
                                         String numero,
                                         String bairro,
                                         @Nullable String distrito,
                                         @Nullable String complemento);

    Endereco enderecoSuspeito(Cep cep,
                              String logradouro,
                              String numero,
                              String bairro,
                              int municipio,
                              @Nullable String distrito,
                              @Nullable String complemento);

}
