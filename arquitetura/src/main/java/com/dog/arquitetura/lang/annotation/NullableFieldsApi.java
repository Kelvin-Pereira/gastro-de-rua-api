package com.dog.arquitetura.lang.annotation;

import javax.annotation.meta.TypeQualifierDefault;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.annotation.Nullable;

@Target(ElementType.PACKAGE)
@Retention(RetentionPolicy.RUNTIME)
@Nullable
@TypeQualifierDefault({ElementType.FIELD})
public @interface NullableFieldsApi {
}
