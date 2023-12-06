package com.dog.core.correios;


import com.dog.core.correios.internal.CepFromString;
import com.dog.core.correios.internal.CepPredicate;

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
