package com.dog.postgres.auth.domain.mapper;

import com.dog.core.auth.domain.entity.Address;
import com.dog.core.auth.domain.entity.AddressRequest;
import com.dog.postgres.auth.domain.entity.AddressEntity;

public class AddressMapper {
    private AddressMapper(){
    }

    public static Address toAddress(AddressEntity addressEntity){
        Address address = new Address();
        address.setId(addressEntity.getId());
        address.setPostalCode(addressEntity.getPostalCode());
        address.setStreet(addressEntity.getStreet());
        address.setNumber(addressEntity.getNumber());
        address.setComplement(addressEntity.getComplement());
        address.setNeighborhood(addressEntity.getNeighborhood());
        address.setCity(addressEntity.getCity());
        address.setState(addressEntity.getState());
        address.setIbgeCode(addressEntity.getIbgeCode());
        address.setGia(addressEntity.getGia());
        address.setDdd(addressEntity.getDdd());
        address.setSiafi(addressEntity.getSiafi());
        address.setIsPrimary(addressEntity.getIsPrimary());
        address.setCreatedAt(addressEntity.getCreatedAt());
        address.setUpdatedAt(addressEntity.getUpdatedAt());
        return address;
    }

    public static AddressEntity toAddressEntity(AddressRequest addressRequest){
     return AddressEntity.builder()
             .postalCode(addressRequest.getPostalCode())
             .street(addressRequest.getStreet())
             .number(addressRequest.getNumber())
             .complement(addressRequest.getComplement())
             .neighborhood(addressRequest.getNeighborhood())
             .city(addressRequest.getCity())
             .state(addressRequest.getState())
             .ibgeCode(addressRequest.getIbgeCode())
             .gia(addressRequest.getGia())
             .ddd(addressRequest.getDdd())
             .siafi(addressRequest.getSiafi())
             .isPrimary(addressRequest.getIsPrimary())
             .build();
    }


}
