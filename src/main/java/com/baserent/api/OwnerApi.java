package com.baserent.api;

import com.baserent.authentication.AuthUtils;
import com.baserent.domain.owner.ImmutableOwner;
import com.baserent.domain.owner.Owner;
import com.baserent.domain.service.OwnerService;
import com.baserent.infrastructure.dto.incoming.owner.ImmutableOwnerSignUpRequestDto;
import com.baserent.infrastructure.dto.incoming.owner.OwnerSignUpRequestDto;
import com.baserent.infrastructure.dto.outgoing.owner.ImmutableOwnerSignUpResponseDto;
import com.baserent.infrastructure.dto.outgoing.owner.OwnerSignUpResponseDto;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.jooq.exception.DataAccessException;

@Singleton
public class OwnerApi {
    @Inject
    private OwnerService ownerService;

    @Inject
    private AuthUtils authUtils;

    public int save(OwnerSignUpRequestDto ownerSignUpRequestDto) throws DataAccessException {
        return ownerService.save(toDomain(ImmutableOwnerSignUpRequestDto.builder()
                .password(authUtils.encryptPassword(ownerSignUpRequestDto.getPassword()))
                .email(ownerSignUpRequestDto.getEmail())
                .lastName(ownerSignUpRequestDto.getLastName())
                .firstName(ownerSignUpRequestDto.getFirstName())
                .build()));
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
