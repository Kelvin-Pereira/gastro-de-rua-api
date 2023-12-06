package com.dog.web.auth;

import com.dog.arquitetura.brasil.Email;
import com.dog.arquitetura.brasil.Telefone;
import com.dog.core.auth.UserApi;
import com.dog.web.type.InputType;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.function.Function;

@RequiredArgsConstructor
public class UcRegistrarUsuario implements Function<UcRegistrarUsuario.Input, Long> {

    private final UserApi userApi;

    @Override // criptografar a senha
    public Long apply(Input input) {
        var user = userApi.register(new UserApi.Usuario(input.nome(),
                input.email(),
                input.birthDate(),
                input.telefone(),
                input.password()));

        return 1L;
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
