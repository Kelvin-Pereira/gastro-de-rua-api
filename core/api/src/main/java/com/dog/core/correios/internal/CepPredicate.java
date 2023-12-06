package com.dog.core.correios.internal;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public enum CepPredicate implements Predicate<String> {

    /**
     * CEPs 00xxxyyy são inválidos
     */
    REGEX_VALIDATOR {
        private final Pattern validos = Pattern.compile("0[1-9]\\d{6}|[1-9]\\d{7}");

        @Override
        public boolean test(String digitos) {
            return validos.matcher(digitos).matches();
        }
    }
}
