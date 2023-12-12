package com.dog.core.auth.domain.enums;

import java.util.Set;

public record Permission(Set<PermissionEnum> permissions) {

//    ADMIN
//                    ADMIN_READ,
//                    ADMIN_UPDATE,
//                    ADMIN_DELETE,
//                    ADMIN_CREATE,
//                    CUSTOMER_READ,
//                    CUSTOMER_UPDATE,
//                    CUSTOMER_DELETE,
//                    CUSTOMER_CREATE

//    USER
//                    CUSTOMER_READ,
//                    CUSTOMER_UPDATE,
//                    CUSTOMER_DELETE,
//                    CUSTOMER_CREATE


//     TODO vai precisar de algo semelhante a isso

    //    public List<SimpleGrantedAuthority> getAuthorities() {
//        var authorities = getPermissions()
//                .stream()
//                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
//                .collect(Collectors.toList());
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
//        return authorities;
//    }


}
