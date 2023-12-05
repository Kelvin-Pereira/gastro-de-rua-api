package com.dog.arquitetura.brasil.internal;

import br.com.caelum.stella.validation.CNPJValidator;

import java.util.function.Predicate;


@SuppressWarnings("java:S1948")
public enum CnpjPredicate implements Predicate<String> {

    STELLA_VALIDATOR {
        private final CNPJValidator validator = new CNPJValidator();

        @Override
        public boolean test(String s) {
            try {
                validator.assertValid(s);
                return true;
            } catch (RuntimeException ignore) {
                return false;
            }
        }
    }

}
