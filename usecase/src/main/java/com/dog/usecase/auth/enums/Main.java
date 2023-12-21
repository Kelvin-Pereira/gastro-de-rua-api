package com.dog.usecase.auth.enums;

import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Permission role = new Permission(Set.of(PermissionEnum.CUSTOMER_CREATE, PermissionEnum.ADMIN_CREATE));


//        role.permissions().forEach(e-> System.out.println(e.getPermission()));
//        role.permissions().forEach(e-> System.out.println(e));

        System.out.println(role.permissions().stream().map(Enum::name).collect(Collectors.joining(",")));
        System.out.println(role.permissions().stream().map(PermissionEnum::getPermission).collect(Collectors.joining(",")));


    }

}
