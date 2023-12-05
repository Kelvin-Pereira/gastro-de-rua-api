package com.dog.arquitetura;


import com.dog.arquitetura.lang.annotation.NonNull;

import java.util.Optional;

public final class DomainException extends RuntimeException {
    private final String code;
    private final String detail;

    public DomainException(@NonNull String code) {
        super(code);
        this.code = code;
        this.detail = null;
    }

    public DomainException(@NonNull String code, Throwable rootCause) {
        super(code, rootCause);
        this.code = code;
        this.detail = null;
    }

    public DomainException(@NonNull String code, @NonNull String detail) {
        super(code + ": " + detail);
        this.code = code;
        this.detail = detail;
    }

    public DomainException(@NonNull String code, @NonNull String detail, Throwable rootCause) {
        super(code + ": " + detail, rootCause);
        this.code = code;
        this.detail = detail;
    }

    @NonNull
    public String code() {
        return code;
    }

    @NonNull
    public Optional<String> detail() {
        return Optional.ofNullable(detail);
    }

}
