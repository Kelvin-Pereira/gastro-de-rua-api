package com.dog.usecase.auth;

import com.dog.arquitetura.brasil.Email;
import com.dog.arquitetura.brasil.Telefone;
import com.dog.core.auth.UserApi;
import com.dog.usecase.type.InputType;
import com.dog.usecase.type.auth.TokenType;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.function.Function;

@RequiredArgsConstructor
public class UcRegistrarUsuario implements Function<UcRegistrarUsuario.Input, TokenType> {

    private final UserApi userApi;

    @Override
    public TokenType apply(Input input) {
        return new TokenType(userApi.register(new UserApi.User(input.nome(),
                input.email(),
                input.birthDate(),
                input.telefone(),
                input.password())));
    }

    public record Input(String nome,
                        String usuario,
                        LocalDate birthDate,
                        String password,
                        String phone) implements InputType {
        private Email email() {
            return emailRequerido(usuario);
        }

        private Telefone telefone() {
            return telefoneRequerido(usuario);
        }
    }

}
