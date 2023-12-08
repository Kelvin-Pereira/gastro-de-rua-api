package com.dog.web.type.auth;

import com.dog.web.type.InputType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserType implements InputType {

    private String name;

    private String email;

    private LocalDate birthDate;

    private String phone;

    private String password;

}
