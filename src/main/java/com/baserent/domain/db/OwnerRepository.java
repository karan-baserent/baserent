package com.baserent.domain.db;

import com.baserent.domain.owner.Owner;

public interface OwnerRepository {

    Owner findByEmail(String email);

    Owner save(Owner owner);
}
