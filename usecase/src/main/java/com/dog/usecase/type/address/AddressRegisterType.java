package com.dog.usecase.type.address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRegisterType {

    private String postalCode;
    private String street;
    private Integer number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private Boolean isPrimary;

}
