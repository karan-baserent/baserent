package com.baserent.service.owner;

import com.baserent.dto.incoming.owner.OwnerSignUpRequestDto;
import com.baserent.dto.outgoing.owner.OwnerSignUpResponseDto;
import com.baserent.entity.owner.Owner;
import com.baserent.mapper.OwnerMapper;
import com.baserent.repository.owner.OwnerRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class OwnerService {

    @Inject
    OwnerRepository ownerRepository;
    @Inject
    OwnerMapper ownerMapper;
    public OwnerSignUpResponseDto createOwner(OwnerSignUpRequestDto ownerSignUpRequestDto) {
        Owner owner = ownerRepository.save(ownerMapper.toEntity(ownerSignUpRequestDto));
        return ownerMapper.toSignUpDto(owner);
    }
}
