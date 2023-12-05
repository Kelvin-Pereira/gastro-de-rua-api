package com.dog.arquitetura.brasil;


import com.dog.arquitetura.brasil.internal.CnpjFromString;
import com.dog.arquitetura.brasil.internal.CnpjPredicate;

import java.util.Optional;

public interface Cnpj extends Comparable<Cnpj> {

    String digitos();

    default long longValue() {
        return Long.parseLong(digitos());
    }

    default int compareTo(Cnpj o) {
        return digitos().compareTo(o.digitos());
    }

    default String formatado() {
        char[] array = digitos().toCharArray();
        return String.valueOf(new char[]{
                array[0], array[1], '.',
                array[2], array[3], array[4], '.',
                array[5], array[6], array[7], '/',
                array[8], array[9], array[10], array[11], '-',
                array[12], array[13]
        });
    }

    static Cnpj preValidado(String digitos) {
        return new CnpjFromString(digitos);
    }

    static Optional<Cnpj> suspeito(String digitos) {
        if (CnpjPredicate.STELLA_VALIDATOR.test(digitos)) {
            return Optional.of(preValidado(digitos));
        }
        return Optional.empty();
    }

    static Cnpj preValidado(long longValue) {
        return new CnpjFromString(String.format("%014d", longValue));
    }

}
