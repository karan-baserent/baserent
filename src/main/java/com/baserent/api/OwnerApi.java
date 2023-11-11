package com.baserent.api;

import com.baserent.authentication.AuthUtils;
import com.baserent.domain.owner.ImmutableOwner;
import com.baserent.domain.owner.Owner;
import com.baserent.domain.service.OwnerService;
import com.baserent.infrastructure.dto.incoming.owner.OwnerSignUpRequestDto;
import com.baserent.infrastructure.dto.outgoing.owner.ImmutableOwnerSignUpResponseDto;
import com.baserent.infrastructure.dto.outgoing.owner.OwnerSignUpResponseDto;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class OwnerApi {
    @Inject
    private OwnerService ownerService;

    @Inject
    private AuthUtils authUtils;
    public OwnerSignUpResponseDto save(OwnerSignUpRequestDto ownerSignUpRequestDto) {
        ownerSignUpRequestDto.setPassword(authUtils.encryptPassword(ownerSignUpRequestDto.getPassword()));
        Owner owner = ownerService.save(toDomain(ownerSignUpRequestDto));
        return ImmutableOwnerSignUpResponseDto.builder()
                .id(owner.getId().get())
                .firstName(owner.getFirstName())
                .lastName(owner.getLastName())
                .email(owner.getEmail())
                .build();
    }

    private Owner toDomain(OwnerSignUpRequestDto ownerSignUpRequestDto) {
        return ImmutableOwner.builder()
                .firstName(ownerSignUpRequestDto.getFirstName())
                .password(ownerSignUpRequestDto.getPassword())
                .lastName(ownerSignUpRequestDto.getLastName())
                .email(ownerSignUpRequestDto.getEmail())
                .build();
    }
}
