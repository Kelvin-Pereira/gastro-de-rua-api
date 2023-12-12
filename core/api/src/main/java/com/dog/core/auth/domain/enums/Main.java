package com.dog.core.auth.domain.enums;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Permission role = new Permission(Set.of(PermissionEnum.CUSTOMER_CREATE, PermissionEnum.ADMIN_CREATE));
        Permission teste;


        role.permissions().forEach(e-> System.out.println(e.getPermission()));
    }

}
