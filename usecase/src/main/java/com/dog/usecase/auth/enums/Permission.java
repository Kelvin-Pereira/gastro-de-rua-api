package com.dog.usecase.auth.enums;

import java.io.Serializable;
import java.util.Set;

public record Permission(Set<PermissionEnum> permissions) implements Serializable {
}
