package com.dog.usecase.address.type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressByCepType {
    private String postalCode;
    private String street;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;

    // objeto de retorno
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
}
