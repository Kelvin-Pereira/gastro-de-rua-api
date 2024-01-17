package com.dog.web.boot.address;

import com.dog.usecase.address.service.RegisterNewAddressService;
import com.dog.usecase.address.service.SeachAddressByCepService;
import com.dog.usecase.address.type.AddressByCepType;
import com.dog.usecase.auth.perfil.Perfil;
import com.dog.usecase.type.address.AddressRegisterType;
import com.dog.usecase.type.address.AddressResponseType;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final RegisterNewAddressService registerNewAddressService;
    private final SeachAddressByCepService seachAddressByCepService;

    @PostMapping
    public ResponseEntity<AddressResponseType> newAddress(Perfil.Usuario usuario, @RequestBody AddressRegisterType addressRegisterType) {
        AddressResponseType addressResponseType = registerNewAddressService.apply(usuario.user(), addressRegisterType);
        return ResponseEntity.ok().body(addressResponseType);
    }

    @GetMapping("/{cep}")
    public ResponseEntity<AddressByCepType> seachAddressByCep(@PathParam("cep") String cep){
        return ResponseEntity.ok(seachAddressByCepService.apply(cep));
    }


}
