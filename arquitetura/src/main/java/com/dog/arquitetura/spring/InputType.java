package com.dog.arquitetura.spring;


import com.dog.arquitetura.HttpException;
import com.dog.arquitetura.brasil.*;
import com.dog.arquitetura.lang.annotation.Nullable;

import java.util.function.Supplier;

public interface InputType {

    default RuntimeException fail(String errorCode) {
        return HttpException.badRequest(errorCode);
    }

    @Nullable
    default String trimToNull(@Nullable String str) {
        if (str == null || str.isBlank()) return null;
        return str.trim();
    }

    default <T> T notNull(@Nullable T input, String errorCode) {
        if (input == null) throw fail(errorCode);
        return input;
    }

    default <T> T notNull(Supplier<T> input, String errorCode) {
        try {
            return input.get();
        } catch (RuntimeException e) {
            throw fail(errorCode);
        }
    }

    default String notBlank(@Nullable String input, String errorCode) {
        if (input != null && !input.isBlank()) return input;
        throw fail(errorCode);
    }

    default boolean falseIfNull(@Nullable Boolean input) {
        return Boolean.TRUE.equals(input);
    }

    // CPF

    default Cpf cpfRequerido(@Nullable String input) {
        return cpfRequerido(input, "CPF_REQUERIDO", "CPF_INVALIDO");
    }

    default Cpf cpfRequerido(@Nullable String input,
                             String errorCodeAusente,
                             String errorCodeInvalido) {
        return notNull(cpf(trimToNull(input), errorCodeInvalido), errorCodeAusente);
    }

    @Nullable
    default Cpf cpf(@Nullable String input, String errorCode) {
        if (input == null) return null;
        Cpf cpf = Cpf.suspeito(input).orElse(null);
        if (cpf == null) throw fail(errorCode);
        return cpf;
    }

    // CNPJ

    default Cnpj cnpjRequerido(@Nullable String input) {
        return cnpjRequerido(input, "CNPJ_REQUERIDO", "CNPJ_INVALIDO");
    }

    default Cnpj cnpjRequerido(@Nullable String input,
                               String errorCodeAusente,
                               String errorCodeInvalido) {
        return notNull(cnpj(trimToNull(input), errorCodeInvalido), errorCodeAusente);
    }

    @Nullable
    default Cnpj cnpj(@Nullable String input, String errorCode) {
        if (input == null) return null;
        Cnpj cnpj = Cnpj.suspeito(input).orElse(null);
        if (cnpj == null) throw fail(errorCode);
        return cnpj;
    }

    // CEP

    default Cep cepRequerido(@Nullable String input) {
        return cepRequerido(input, "CEP_REQUERIDO", "CEP_INVALIDO");
    }

    default Cep cepRequerido(@Nullable String input,
                             String errorCodeAusente,
                             String errorCodeInvalido) {
        return notNull(cep(trimToNull(input), errorCodeInvalido), errorCodeAusente);
    }

    @Nullable
    default Cep cep(@Nullable String input, String errorCode) {
        if (input == null) return null;
        Cep cnpj = Cep.suspeito(input).orElse(null);
        if (cnpj == null) throw fail(errorCode);
        return cnpj;
    }

    // E-mail

    default Email emailRequerido(@Nullable String input) {
        return emailRequerido(input, "EMAIL_REQUERIDO", "EMAIL_INVALIDO");
    }

    default Email emailRequerido(@Nullable String input, String errorCodeAusente, String errorCodeInvalido) {
        return notNull(email(trimToNull(input), errorCodeInvalido), errorCodeAusente);
    }

    @Nullable
    default Email email(@Nullable String input, String errorCode) {
        if (input == null) return null;
        Email e = Email.suspeito(input).orElse(null);
        if (e == null) throw fail(errorCode);
        return e;
    }

    // Telefone

    default Telefone telefoneRequerido(@Nullable String input) {
        return telefoneRequerido(input, "TELEFONE_REQUERIDO", "TELEFONE_INVALIDO");
    }

    default Telefone telefoneRequerido(@Nullable String input, String errorCodeAusente, String errorCodeInvalido) {
        return notNull(telefone(trimToNull(input), errorCodeInvalido), errorCodeAusente);
    }

    @Nullable
    default Telefone telefone(@Nullable String input, String errorCode) {
        if (input == null) return null;
        Telefone t = Telefone.suspeito(input).orElse(null);
        if (t == null) throw fail(errorCode);
        return t;
    }

}
