package com.baserent.mapper;

import com.baserent.dto.incoming.owner.OwnerSignUpRequestDto;
import com.baserent.dto.outgoing.owner.OwnerSignUpResponseDto;
import com.baserent.entity.owner.Owner;
import jakarta.inject.Singleton;

@Singleton
public class OwnerMapper {
    public Owner toEntity(OwnerSignUpRequestDto ownerSignUpRequestDto) {
        return Owner.OwnerBuilder.anOwner()
                .withFirstName(ownerSignUpRequestDto.getFirstName())
                .withLastName(ownerSignUpRequestDto.getLastName())
                .withEmail(ownerSignUpRequestDto.getEmail())
                .withPassword(ownerSignUpRequestDto.getPassword())
                .build();
    }

    public OwnerSignUpResponseDto toSignUpDto(Owner owner) {
        return OwnerSignUpResponseDto.OwnerSignUpResponseDtoBuilder.anOwnerSignUpResponseDto()
                .withFirstName(owner.getFirstName())
                .withEmail(owner.getEmail())
                .withId(owner.getId())
                .withLastName(owner.getLastName())
                .build();
    }
}
