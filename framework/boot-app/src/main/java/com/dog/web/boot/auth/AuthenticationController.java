package com.dog.web.boot.auth;

import com.dog.usecase.auth.domain.User;
import com.dog.usecase.auth.services.RegistrarUsuarioService;
import com.dog.usecase.type.auth.TokenResponseType;
import com.dog.usecase.type.auth.UserRegisterType;
import com.dog.web.boot.config.security.JwtExtract;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/v1/login")
@RequiredArgsConstructor
public class AuthenticationController {

    private final RegistrarUsuarioService registrarUsuarioService;
    private final JwtExtract jwtExtract;

    @PostMapping("/registrar")
    public ResponseEntity<TokenResponseType> register(@RequestBody UserRegisterType userRegisterType) {

        User user = registrarUsuarioService.apply(userRegisterType);

        var jwtToken = jwtExtract.generateToken(user);
        var refreshToken = jwtExtract.generateRefreshToken(user);

        return ResponseEntity.ok(TokenResponseType.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build());
    }

//    @PostMapping("/autenticar")
//    public ResponseEntity<TokenType> authenticate(@RequestBody AuthenticationRequest request) {
//        return ResponseEntity.ok(userAuthenticateService.apply(request));
//    }
//
//    @PostMapping("/refresh-token")
//    public void refreshToken(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws IOException {
//        tokenRefreshService.accept(request, response);
//    }


}
