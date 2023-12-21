package com.dog.web.boot.config.security.perfil;

import com.dog.arquitetura.HttpException;
import com.dog.arquitetura.brasil.Cnpj;
import com.dog.arquitetura.brasil.internal.CnpjFromString;
import com.dog.usecase.auth.domain.User;
import com.dog.usecase.auth.enums.PermissionEnum;
import com.dog.usecase.auth.perfil.Perfil;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.web.context.request.NativeWebRequest;

public final class UsuarioOAuth2 extends UsuarioArgumentResolver {

    @Override
    protected Object autenticacaoRequerida(MethodParameter parameter, NativeWebRequest webRequest) {
        throw HttpException.autenticacaoRequerida();
    }

    @Override
    protected Perfil extrairPerfil(Authentication authentication, MethodParameter parameter) {
        Perfil perfil = parseUsuario((User) authentication.getPrincipal());
        if (parameter.getParameterType().isInstance(perfil)) {
            return perfil;
        }
        throw HttpException.privilegiosInsuficientes();
    }

    private Perfil parseUsuario(User user) {
        if(user.role().permissions().contains(PermissionEnum.CUSTOMER_USER)){
            return new Perfil.Usuario(user);
        } else if (user.role().permissions().contains(PermissionEnum.STORE_USER)) {
            // TODO create Table store oneToOne with Table user
            return new Perfil.Empresa(user, Cnpj.preValidado("70269444000102"));
        }
        throw HttpException.privilegiosInsuficientes();
    }

}
