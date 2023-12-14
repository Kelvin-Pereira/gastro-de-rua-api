package com.dog.infra.endereco.correios;


import com.dog.arquitetura.brasil.Cep;
import com.dog.infra.endereco.ibge.Municipio;

import java.util.Optional;

public interface Endereco {

    Cep cep();

    String logradouro();

    String bairro();

    String numero();

    Optional<String> complemento();

    Optional<String> distrito();

    Municipio municipio();

    boolean modificado();

    default Proximidade proximidade(Endereco destino) {
        Municipio m1 = municipio();
        Municipio m2 = destino.municipio();
        if (!m1.uf().equals(m2.uf())) return Proximidade.UF_DISTINTA;
        if (!m1.equals(m2)) return Proximidade.MESMA_UF;
        if (!distrito().equals(destino.distrito())) return Proximidade.MESMO_MUNICIPIO;
        return Proximidade.MESMO_DISTRITO;
    }

    enum Proximidade {
        MESMO_DISTRITO,
        MESMO_MUNICIPIO,
        MESMA_UF,
        UF_DISTINTA
    }

}
