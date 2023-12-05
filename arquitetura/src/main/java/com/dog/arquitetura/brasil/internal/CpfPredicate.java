package com.dog.arquitetura.brasil.internal;

import br.com.caelum.stella.validation.CPFValidator;

import java.util.function.Predicate;


@SuppressWarnings("java:S1948")
public enum CpfPredicate implements Predicate<String> {

    STELLA_VALIDATOR {
        private final CPFValidator validator = new CPFValidator();

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
