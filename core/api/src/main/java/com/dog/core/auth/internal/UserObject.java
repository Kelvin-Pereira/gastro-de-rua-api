package com.dog.core.auth.internal;

import com.dog.core.auth.domain.entity.User;

public abstract class UserObject implements User {

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof User that) return email().equals(that.email());
        return false;
    }

    @Override
    public final int hashCode() {
        return email().hashCode();
    }

}
