package com.dog.postgres.auth.domain.entity;


import com.dog.postgres.converter.PermissionEnumSetConverter;
import com.dog.usecase.auth.domain.User;
import com.dog.usecase.auth.enums.Permission;
import com.dog.usecase.auth.enums.PermissionEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
@EntityListeners(AuditingEntityListener.class)
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 255)
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank
    @Email
    @Size(max = 255)
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @NotBlank
    @Size(max = 100)
    @Column(name = "password", nullable = false)
    private String password;

    @Size(max = 255)
    @Column(name = "url_photo")
    private String urlPhoto;

    @NotBlank
    @Pattern(regexp = "\\d{10,11}")
    @Size(max = 11)
    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "role", nullable = false)
    @Convert(converter = PermissionEnumSetConverter.class)
    private Permission role;

    @OneToMany(mappedBy = "userEntity")
    private List<TokenEntity> tokenEntities;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<AddressEntity> addressEntities;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    public UserEntity(User user) {
        this.name = user.name();
        this.email = user.email();
        this.birthDate = user.birthDate();
        this.password = user.password();
        this.phone = user.phone();
        this.role = user.role();
        this.addressEntities = user.address().stream().map(address -> new AddressEntity(address, this)).toList();
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    public AddressEntity getAddressPrincipal() {
        Optional<AddressEntity> optionalAddress = getAddressEntities()
                .stream()
                .filter(AddressEntity::getIsPrimary)
                .findFirst();
        return optionalAddress.orElse(null);
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @PreRemove
    protected void onDelete() {
        deletedAt = LocalDateTime.now();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthorities(role.permissions());
    }

    public static List<SimpleGrantedAuthority> getAuthorities(Set<PermissionEnum> permission) {
        return permission
                .stream()
                .map(permissionEnum -> new SimpleGrantedAuthority(permissionEnum.name()))
                .toList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
