package com.dog.usecase.auth.services;

import com.dog.usecase.auth.domain.User;
import com.dog.usecase.auth.enums.Permission;
import com.dog.usecase.auth.enums.PermissionEnum;
import com.dog.usecase.auth.repository.UserRegisterRepository;
import com.dog.usecase.auth.services.token.CryptoPasswordService;
import com.dog.usecase.mapper.UserRegisterTypeToUserMapper;
import com.dog.usecase.type.auth.TokenResponseType;
import com.dog.usecase.type.auth.UserRegisterType;
import lombok.RequiredArgsConstructor;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.Function;

import static com.dog.usecase.auth.enums.PermissionEnum.*;

@RequiredArgsConstructor
public final class RegistrarUsuarioService implements Function<UserRegisterType, TokenResponseType> {

    private final UserRegisterRepository userRegisterRepository;
    private final CryptoPasswordService cryptoPassWordService;

    @Override
    public TokenResponseType apply(UserRegisterType input) {
        cryptoPassword(input);

        User user = userRegisterRepository.register(new UserRegisterTypeToUserMapper(input, userPermissions()));

        return new TokenResponseType();
    }

    private void cryptoPassword(UserRegisterType input){
        input.setPassword(cryptoPassWordService.apply(input.getPassword()));
    }

    private Permission userPermissions() {
        return new Permission(EnumSet.of(CUSTOMER_READ, CUSTOMER_UPDATE, CUSTOMER_CREATE, CUSTOMER_DELETE));
    }

}
