package com.dog.arquitetura.brasil.internal;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@SuppressWarnings("java:S5843")
public enum TelefonePredicate implements Predicate<String> {

    REGEX_VALIDATOR {
        private final Pattern validos =
                Pattern.compile("(1[1-9]|2[12478]|3[1234578]|4[1-9]|5[1345]|6[1-9]|7[134579]|8[1-9]|9[1-9])(([6-9]\\d{7,8})|([2-5]\\d{6,7}))");

        @Override
        public boolean test(String digitosComDDD) {
            return validos.matcher(digitosComDDD).matches();
        }
    }

    // 619918154744
    // 83998660-2971
    // 919888920040

}
