package com.dog.postgres.auth.domain.mapper;

import com.dog.core.auth.domain.entity.User;
import com.dog.core.auth.domain.entity.UserRegisterRequest;
import com.dog.postgres.auth.domain.entity.UserEntity;
import com.dog.postgres.auth.domain.enums.Role;

import java.util.List;

public class UserMapper {

    private UserMapper() {
    }

    public static User toUser(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setEmail(userEntity.getUsername());
        user.setPhone(userEntity.getPhone());
        user.setRole(userEntity.getRole().toString());
        user.setAddress(userEntity.getAddressEntities().stream().map(AddressMapper::toAddress).toList());
        return user;
    }

    public static UserEntity toUserEntity(UserRegisterRequest userRegisterRequest){
        return UserEntity.builder()
                .name(userRegisterRequest.getName())
                .email(userRegisterRequest.getEmail().endereco())
                .birthDate(userRegisterRequest.getBirthDate())
                .password(userRegisterRequest.getPassword())
                .role(Role.valueOf(userRegisterRequest.getRole()))
                .addressEntities(List.of(AddressMapper.toAddressEntity(userRegisterRequest.getAddress())))
                .build();
    }

}
