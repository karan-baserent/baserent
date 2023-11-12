package com.baserent.domain.db;

import com.baserent.domain.owner.Owner;
import org.jooq.exception.DataAccessException;

public interface OwnerRepository {

    Owner findByEmail(String email);

    int save(Owner owner) throws DataAccessException;
}
