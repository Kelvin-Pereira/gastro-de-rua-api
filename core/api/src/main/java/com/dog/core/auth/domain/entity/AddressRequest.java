package com.dog.core.auth.domain.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class AddressRequest {

    private String postalCode;
    private String street;
    private Integer number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String ibgeCode;
    private String gia;
    private String ddd;
    private String siafi;
    private Boolean isPrimary;

}
