package com.dog.postgres.converter;

import com.dog.usecase.auth.enums.Permission;
import com.dog.usecase.auth.enums.PermissionEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Converter(autoApply = true)
@ReadingConverter
@WritingConverter
public class PermissionEnumSetConverter implements AttributeConverter<Permission, String> {

    private static final String DELIMITER = ",";

    @Override
    public String convertToDatabaseColumn(Permission attribute) {
        if (attribute == null || attribute.permissions() == null) {
            return null;
        }

        return attribute.permissions().stream()
                .map(PermissionEnum::name)
                .collect(Collectors.joining(DELIMITER));
    }

    @Override
    public Permission convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return new Permission(Set.of());
        }

        Set<PermissionEnum> permissions = Stream.of(dbData.split(DELIMITER))
                .map(PermissionEnum::valueOf)
                .collect(Collectors.toSet());

        return new Permission(permissions);
    }
}