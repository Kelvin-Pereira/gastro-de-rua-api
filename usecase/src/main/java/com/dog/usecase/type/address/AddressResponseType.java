package com.dog.usecase.type.address;

import com.dog.usecase.address.domain.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponseType {


    private String postalCode;
    private String street;
    private Integer number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private Boolean isPrimary;

    public AddressResponseType(Address address){
        this.postalCode = address.postalCode();
        this.street = address.street();
        this.number = address.number();
        this.complement = address.complement();
        this.neighborhood = address.neighborhood();
        this.city = address.city();
        this.state = address.state();
        this.isPrimary = address.isPrimary();

    }


}
