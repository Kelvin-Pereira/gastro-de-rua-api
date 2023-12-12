package com.dog.web.boot.auth;

import com.dog.usecase.auth.services.RegistrarUsuarioService;
import com.dog.usecase.type.auth.TokenResponseType;
import com.dog.usecase.type.auth.UserRegisterType;
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

    @PostMapping("/registrar")
    public ResponseEntity<TokenResponseType> register(@RequestBody UserRegisterType userRegisterType) {
        return ResponseEntity.ok(registrarUsuarioService.apply(userRegisterType));
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
