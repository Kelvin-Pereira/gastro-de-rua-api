package com.dog.core.correios;

import java.util.Optional;

public interface LogradouroSearchApi {

    Logradouro logradouroAproximado(Cep cep);

    Optional<Logradouro> logradouroExato(Cep cep);

}
