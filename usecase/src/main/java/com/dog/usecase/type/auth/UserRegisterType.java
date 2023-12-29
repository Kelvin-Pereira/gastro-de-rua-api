package com.dog.usecase.type.auth;

import com.dog.usecase.type.address.AddressRegisterType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRegisterType {

    private String name;
    private String email;
    private LocalDate birthDate;
    private String phone;
    private String password;
    private AddressRegisterType address;

}
