package com.dog.postgres.auth.repository;

import com.dog.postgres.auth.domain.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepositoryJpa extends JpaRepository<TokenEntity, Long> {
    @Query(value = """
      select t from TokenEntity t inner join UserEntity u
      on t.userEntity.id = u.id
      where u.id = :id and (t.expired = false or t.revoked = false)
      """)
    List<TokenEntity> findAllValidTokenByUser(Long id);

    Optional<TokenEntity> findByJwt(String token);
}
