package com.dog.core.ibge;


import com.dog.core.ibge.internal.UfEnum;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface Uf {

    int codigoIbge();

    String sigla();

    String nome();

    int codigoIbgeCapital();

    static List<Uf> todas() {
        return Arrays.asList(UfEnum.values());
    }

    static Uf preValidada(String sigla) {
        return UfEnum.valueOf(sigla);
    }

    static Optional<Uf> suspeita(String sigla) {
        try {
            return Optional.of(preValidada(sigla.toUpperCase()));
        } catch (RuntimeException e) {
            return Optional.empty();
        }
    }

}
