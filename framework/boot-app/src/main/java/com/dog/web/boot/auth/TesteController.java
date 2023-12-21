package com.dog.web.boot.auth;

import com.dog.usecase.auth.perfil.Perfil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/teste")
public class TesteController {


    @GetMapping("/perfil")
    public String teste(Perfil.Usuario usuario){
        return usuario.user().name();
    }

}
