package com.dog.web.auth;

import com.dog.arquitetura.brasil.Email;
import com.dog.arquitetura.brasil.Telefone;
import com.dog.core.auth.UserApi;
import com.dog.core.auth.domain.entity.AddressRequest;
import com.dog.core.auth.domain.entity.TokenResponse;
import com.dog.core.auth.domain.entity.User;
import com.dog.core.auth.domain.entity.UserRegisterRequest;
import com.dog.web.type.InputType;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.function.Function;

@RequiredArgsConstructor
public class UcRegistrarUsuario implements Function<UcRegistrarUsuario.Input, TokenResponse> {

    private final UserApi userApi;

    private static final String CUSTOMER = "CUSTOMER";

    @Override // criptografar a senha
    public TokenResponse apply(Input input) {

        input.address.setIsPrimary(false);

        User user = userApi.register(new UserRegisterRequest(
                input.nome,
                input.email(),
                input.birthDate(),
                input.password(),
                input.telefone(),
                CUSTOMER,
                input.address()));

        System.out.println(user.getName());

        return new TokenResponse();
    }

    public record Input(String nome,
                        String usuario,
                        LocalDate birthDate,
                        String password,
                        String phone,
                        AddressRequest address) implements InputType {
        private Email email() {
            return emailRequerido(usuario);
        }

        private Telefone telefone() {
            return telefoneRequerido(usuario);
        }
    }

}
