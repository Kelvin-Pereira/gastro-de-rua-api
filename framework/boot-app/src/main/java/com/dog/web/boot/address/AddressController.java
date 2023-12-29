package com.dog.web.boot.address;

import com.dog.usecase.address.service.RegisterNewAddressService;
import com.dog.usecase.auth.perfil.Perfil;
import com.dog.usecase.type.address.AddressRegisterType;
import com.dog.usecase.type.address.AddressResponseType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final RegisterNewAddressService registerNewAddressService;

    @PostMapping
    public ResponseEntity<AddressResponseType> newAddress(Perfil.Usuario usuario, @RequestBody AddressRegisterType addressRegisterType) {

        AddressResponseType addressResponseType = registerNewAddressService.apply(usuario.user(), addressRegisterType);


        return ResponseEntity.ok().body(addressResponseType);
    }


}
