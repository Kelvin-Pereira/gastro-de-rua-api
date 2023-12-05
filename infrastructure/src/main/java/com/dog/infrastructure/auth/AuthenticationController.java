package com.dog.infrastructure.auth;

import com.dog.usecase.auth.UcRegistrarUsuario;
import com.dog.usecase.type.auth.TokenType;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/v1/login/usuario")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UcRegistrarUsuario ucRegistrarUsuario;

    @PostMapping("/registrar")
    public ResponseEntity<TokenType> register(@RequestBody @Valid UcRegistrarUsuario.Input request) {
        return ResponseEntity.ok(ucRegistrarUsuario.apply(request));
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
