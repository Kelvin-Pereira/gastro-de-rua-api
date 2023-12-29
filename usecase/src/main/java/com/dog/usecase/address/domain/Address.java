package com.dog.usecase.address.domain;

import java.time.LocalDateTime;

public interface Address {

    Long id();
    String postalCode();
    String street();
    Integer number();
    String complement();
    String neighborhood();
    String city();
    String state();
    Boolean isPrimary();
    Long idUser();
    LocalDateTime createdAt();
    LocalDateTime updatedAt();

}
