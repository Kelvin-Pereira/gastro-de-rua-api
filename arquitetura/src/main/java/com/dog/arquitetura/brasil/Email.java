package com.dog.arquitetura.brasil;

import com.dog.arquitetura.brasil.internal.EmailFromString;
import com.dog.arquitetura.brasil.internal.EmailPredicate;

import java.util.Optional;

public interface Email extends Comparable<Email> {

    String endereco();

    @Override
    default int compareTo(Email o) {
        return endereco().compareTo(o.endereco());
    }

    static Email preValidado(String endereco) {
        return new EmailFromString(endereco);
    }

    static Optional<Email> suspeito(String endereco) {
        if (EmailPredicate.APACHE_COMMONS_VALIDATOR.test(endereco)) {
            return Optional.of(preValidado(endereco));
        }
        return Optional.empty();
    }

}
