package com.dog.arquitetura.brasil;

import com.dog.arquitetura.brasil.internal.CepFromString;
import com.dog.arquitetura.brasil.internal.CepPredicate;

import java.util.Optional;

public interface Cep extends Comparable<Cep> {

    String digitos();

    default String formatado() {
        String d = digitos();
        return d.substring(0, 5) + "-" + d.substring(5);
    }

    @Override
    default int compareTo(Cep o) {
        return digitos().compareTo(o.digitos());
    }

    static Cep preValidado(String digitos) {
        return new CepFromString(digitos);
    }

    static Optional<Cep> suspeito(String digitos) {
        if (CepPredicate.REGEX_VALIDATOR.test(digitos)) {
            return Optional.of(preValidado(digitos));
        }
        return Optional.empty();
    }

}
