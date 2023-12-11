package com.dog.core.auth.domain.entity;

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

    LocalDateTime createdAt();

    LocalDateTime updatedAt();

}
