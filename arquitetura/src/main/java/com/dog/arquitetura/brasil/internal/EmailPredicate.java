package com.dog.arquitetura.brasil.internal;

import org.apache.commons.validator.routines.DomainValidator;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.function.Predicate;

public enum EmailPredicate implements Predicate<String> {

    APACHE_COMMONS_VALIDATOR {
        private final EmailValidator validator =
                new EmailValidator(false, true, DomainValidator.getInstance(false));

        @Override
        public boolean test(String endereco) {
            return !endereco.isBlank() && validator.isValid(endereco);
        }
    }

}
