package com.dog.arquitetura.brasil;

import com.dog.arquitetura.brasil.internal.TelefoneFromString;
import com.dog.arquitetura.brasil.internal.TelefonePredicate;

import java.util.Optional;

public interface Telefone extends Comparable<Telefone> {

    String digitos();

    @Override
    default int compareTo(Telefone o) {
        return digitos().compareTo(o.digitos());
    }

    static Telefone preValidado(String digitos) {
        return new TelefoneFromString(nonoDigito(digitos));
    }

    static Optional<Telefone> suspeito(String digitos) {
        if (TelefonePredicate.REGEX_VALIDATOR.test(digitos)) {
            return Optional.of(preValidado(digitos));
        }
        return Optional.empty();
    }

    private static String nonoDigito(String digitos) {
        if (digitos.length() == 8) {
            return switch (digitos.charAt(0)) {
                case '6', '7', '8', '9' -> "9" + digitos;
                default -> digitos;
            };
        }
        return digitos;
    }

}
