package com.dog.usecase.auth.services.token;

import com.dog.usecase.address.domain.Address;
import com.dog.usecase.auth.domain.User;
import com.dog.usecase.auth.enums.PermissionEnum;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public final class ClaimsService implements Function<User, Map<String, Object>> {

    @Override
    public Map<String, Object> apply(User user) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("user", createUserClaims(user));
        claims.put("address", createAddressClaims(user.getAddressPrincipal()));
        claims.put("role", extractRoles(user));

        return claims;
    }

    private Map<String, Object> createUserClaims(User user) {
        Map<String, Object> claimsUser = new HashMap<>();
        claimsUser.put("id", user.id());
        claimsUser.put("name", user.name());
        claimsUser.put("email", user.email());
        claimsUser.put("birthDate", user.birthDate().toString());
        claimsUser.put("urlPhoto", user.urlPhoto());
        return claimsUser;
    }

    private Map<String, Object> createAddressClaims(Address address) {
        if (address != null) {
            Map<String, Object> claimsAddress = new HashMap<>();
            claimsAddress.put("postalCode", address.postalCode());
            claimsAddress.put("street", address.street());
            claimsAddress.put("number", address.number());
            claimsAddress.put("complement", address.complement());
            claimsAddress.put("neighborhood", address.neighborhood());
            claimsAddress.put("city", address.city());
            claimsAddress.put("state", address.state());
            return claimsAddress;
        }
        return Collections.emptyMap();
    }

    private String extractRoles(User user) {
        return user.role().permissions().stream().map(PermissionEnum::getPermission).collect(Collectors.joining(","));
    }

}
