package com.dog.infra.endereco.correios;

import com.dog.arquitetura.brasil.Cep;

import java.util.Optional;

public interface LogradouroSearchApi {

    Logradouro logradouroAproximado(Cep cep);

    Optional<Logradouro> logradouroExato(Cep cep);

}
