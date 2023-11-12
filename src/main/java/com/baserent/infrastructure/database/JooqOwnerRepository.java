package com.baserent.infrastructure.database;

import com.baserent.domain.db.OwnerRepository;
import com.baserent.domain.owner.ImmutableOwner;
import com.baserent.domain.owner.Owner;
import com.baserent.jooq.baserent.tables.OWNER;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;

@Singleton
public class JooqOwnerRepository implements OwnerRepository {

    @Inject
    private DSLContext context;
    @Override
    public Owner findByEmail(String email) {
        return null;
    }

    @Override
    public int save(Owner owner) throws DataAccessException {
        return context.insertInto(OWNER.OWNER)
                .set(context.newRecord(OWNER.OWNER, owner))
                .returning(OWNER.OWNER.ID)
                .fetchOne()
                .getValue(OWNER.OWNER.ID);
    }

    private Owner toDomain(com.baserent.jooq.baserent.tables.records.OWNER result) {
        return ImmutableOwner.builder()
                .id(result.getValue(OWNER.OWNER.ID))
                .build();
    }
}
