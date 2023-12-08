package com.dog.web.type.auth;

import com.dog.web.type.InputType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRegisterType implements InputType {


    private String postalCode;

    private String street;

    private Integer number;

    private String complement;

    private String neighborhood;

    private String city;

    private String state;

}
