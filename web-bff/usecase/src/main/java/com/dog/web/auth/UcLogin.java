package com.dog.web.auth;

import com.dog.arquitetura.brasil.Email;
import com.dog.web.type.InputType;
import com.dog.arquitetura.lang.annotation.Nullable;

public class UcLogin {

    public record Input(String usuario,
                        @Nullable String senha) implements InputType {
        private Email email() {return emailRequerido(usuario);}

    }

}
