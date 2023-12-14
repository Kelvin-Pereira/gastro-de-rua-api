package com.dog.infra.endereco.ibge;


import com.dog.arquitetura.DomainException;

import java.util.Collection;
import java.util.Optional;

public interface MunicipioSearchApi {

    Collection<Municipio> todos(Uf uf);

    Optional<Municipio> comCodigo(int codigoIbge);

    default Municipio requerido(int codigoIbge) {
        return comCodigo(codigoIbge)
                .orElseThrow(() -> new DomainException("MUNICIPIO_INVALIDO", Integer.toString(codigoIbge)));
    }

}
