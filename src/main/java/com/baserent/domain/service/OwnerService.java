package com.baserent.domain.service;

import com.baserent.domain.db.OwnerRepository;
import com.baserent.domain.owner.Owner;
import com.baserent.infrastructure.dto.incoming.owner.OwnerSignInRequestDto;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class OwnerService {

    @Inject
    private OwnerRepository ownerRepository;
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Owner findByEmail(OwnerSignInRequestDto ownerSignInRequestDto) {
        return null;
    }
}

