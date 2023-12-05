package com.dog.arquitetura.brasil;


import com.dog.arquitetura.brasil.internal.CpfFromString;
import com.dog.arquitetura.brasil.internal.CpfPredicate;

import java.util.Optional;

public interface Cpf extends Comparable<Cpf> {

    String digitos();

    default String formatado() {
        char[] array = digitos().toCharArray();
        return String.valueOf(new char[]{
                array[0], array[1], array[2], '.',
                array[3], array[4], array[5], '.',
                array[6], array[7], array[8], '-',
                array[9], array[10]
        });
    }

    @Override
    default int compareTo(Cpf o) {
        return digitos().compareTo(o.digitos());
    }

    static Cpf preValidado(String digitos) {
        return new CpfFromString(digitos);
    }

    static Optional<Cpf> suspeito(String digitos) {
        if (CpfPredicate.STELLA_VALIDATOR.test(digitos)) {
            return Optional.of(preValidado(digitos));
        }
        return Optional.empty();
    }

}
