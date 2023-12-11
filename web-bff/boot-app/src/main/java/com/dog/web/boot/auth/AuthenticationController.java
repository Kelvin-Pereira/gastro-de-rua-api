package com.dog.web.boot.auth;

import com.dog.core.auth.domain.entity.TokenResponse;
import com.dog.web.auth.UcRegistrarUsuario;
import com.dog.web.type.auth.AddressRegisterType;
import com.dog.web.type.auth.UserRegisterType;
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

    private final UcRegistrarUsuario ucRegistrarUsuario;

    @PostMapping("/registrar")
    public ResponseEntity<TokenResponse> register(@RequestBody UserRegisterType userRegisterType) {
        return ResponseEntity.ok(ucRegistrarUsuario.apply(new UcRegistrarUsuario.Input(userRegisterType, new AddressRegisterType())));
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
