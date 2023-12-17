package com.dog.usecase.auth.services.token;

import com.dog.usecase.auth.domain.Address;
import com.dog.usecase.auth.domain.User;
import com.dog.usecase.auth.services.user.FindUserByEmailUserService;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public final class ClaimsService implements Function<String, Map<String, Object>> {

    private final FindUserByEmailUserService findUserByEmailUserService;

    @Override
    public Map<String, Object> apply(String email) {
        User user = findUserByEmail(email);

        Map<String, Object> claims = new HashMap<>();
        claims.put("user", createUserClaims(user));
        claims.put("email", user.email());
        claims.put("address", createAddressClaims(user.getAddressPrincipal()));
        claims.put("role", extractRoles(user));

        return claims;
    }

    private User findUserByEmail(String email) {
        // TODO exception tratar
        return findUserByEmailUserService.apply(email).orElseThrow();
    }

    private Map<String, Object> createUserClaims(User user) {
        Map<String, Object> claimsUser = new HashMap<>();
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
        return user.role().permissions().stream().map(Enum::name).collect(Collectors.joining(","));
    }

}
