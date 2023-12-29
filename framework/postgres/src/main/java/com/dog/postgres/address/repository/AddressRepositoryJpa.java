package com.dog.postgres.address.repository;

import com.dog.postgres.address.domain.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepositoryJpa extends JpaRepository<AddressEntity, Long> {
}
