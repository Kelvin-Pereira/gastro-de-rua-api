package com.dog.web.boot.auth;

import com.dog.usecase.auth.domain.User;
import com.dog.usecase.auth.services.user.FindUserByEmailUserService;
import com.dog.usecase.auth.services.user.RegistrarUsuarioService;
import com.dog.usecase.type.auth.AuthenticationRequest;
import com.dog.usecase.type.auth.TokenResponseType;
import com.dog.usecase.type.auth.UserRegisterType;
import com.dog.web.boot.config.security.JwtExtract;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/v1/login")
@RequiredArgsConstructor
public class AuthenticationController {

    private final JwtExtract jwtExtract;
    private final AuthenticationManager authenticationManager;
    private final RegistrarUsuarioService registrarUsuarioService;
    private final FindUserByEmailUserService findUserByEmailUserService;

    @PostMapping("/registrar")
    public ResponseEntity<TokenResponseType> register(@RequestBody UserRegisterType userRegisterType) {

        User user = registrarUsuarioService.apply(userRegisterType);

        // Todo salvar usar bloqueado, ativar apos validacao do email.

        return getTokenResponseTypeResponseEntity(user);
    }

    @PostMapping("/autenticar")
    public ResponseEntity<TokenResponseType> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {

        // valida se usuario e senha
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.email(),
                        authenticationRequest.password()
                )
        );
        // TODO tratar lancamento de excesao
        User user = findUserByEmailUserService.apply(authenticationRequest.email()).orElseThrow();

        return getTokenResponseTypeResponseEntity(user);
    }

//    @PostMapping("/refresh-token")
//    public void refreshToken(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws IOException {
//        tokenRefreshService.accept(request, response);
//    }

    private ResponseEntity<TokenResponseType> getTokenResponseTypeResponseEntity(User user) {
        var jwtToken = jwtExtract.generateToken(user);
        var refreshToken = jwtExtract.generateRefreshToken(user);

        return ResponseEntity.ok(TokenResponseType.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build());
    }


}
