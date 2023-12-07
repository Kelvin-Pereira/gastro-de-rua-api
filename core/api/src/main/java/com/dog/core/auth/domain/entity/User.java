package com.dog.core.auth.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private String urlPhoto;
    private String phone;
    private String role;
    private List<Token> tokens;
    private List<Address> address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Address getAddressPrincipal() {
        Optional<Address> optionalAddress = getAddress()
                .stream()
                .filter(Address::getIsPrimary)
                .findFirst();
        return optionalAddress.orElse(null);
    }

}
