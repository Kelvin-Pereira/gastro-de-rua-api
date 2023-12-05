package com.dog.usecase.type;


import com.dog.arquitetura.brasil.Cnpj;
import com.dog.arquitetura.brasil.Cpf;
import com.dog.arquitetura.brasil.Email;
import com.dog.arquitetura.brasil.Telefone;
import com.dog.arquitetura.lang.annotation.Nullable;

public interface OutputType {

    @Nullable
    default String digitosOuNull(@Nullable Cpf cpf) {
        return cpf == null ? null : cpf.digitos();
    }

    @Nullable
    default String digitosOuNull(@Nullable Cnpj cnpj) {
        return cnpj == null ? null : cnpj.digitos();
    }

    @Nullable
    default String digitosOuNull(@Nullable Telefone telefone) {
        return telefone == null ? null : telefone.digitos();
    }

    @Nullable
    default String enderecoOuNull(@Nullable Email email) {
        return email == null ? null : email.endereco();
    }

}
