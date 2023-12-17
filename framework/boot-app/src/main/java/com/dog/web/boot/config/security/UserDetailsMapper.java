package com.dog.web.boot.config.security;

import com.dog.usecase.auth.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public record UserDetailsMapper(User user) implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.role().permissions().stream().map(permissionEnum -> new SimpleGrantedAuthority(permissionEnum.name())).toList();
    }

    @Override
    public String getPassword() {
        return user.password();
    }

    @Override
    public String getUsername() {
        return user.email();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }
}
