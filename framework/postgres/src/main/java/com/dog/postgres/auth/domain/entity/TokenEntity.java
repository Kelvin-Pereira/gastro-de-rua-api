package com.dog.postgres.auth.domain.entity;

import com.dog.usecase.auth.domain.Token;
import com.dog.usecase.auth.enums.TokenType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "token")
public class TokenEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Size(max = 100000)
  @Column(name = "jwt", unique = true)
  public String jwt;

  @Enumerated(EnumType.STRING)
  public TokenType tokenType;

  @Column(name = "expired")
  public boolean revoked;

  @Column(name = "revoked")
  public boolean expired;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  public UserEntity userEntity = new UserEntity();

    public TokenEntity(Token token) {
        this.id = token.id();
        this.jwt = token.jwt();
        this.tokenType = TokenType.BEARER;
        this.revoked = token.isRevoked();
        this.expired = token.isExpired();
        this.userEntity.setId(token.idUser());
    }

}
