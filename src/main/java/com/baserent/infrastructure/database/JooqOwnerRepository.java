package com.baserent.infrastructure.database;

import com.baserent.domain.db.OwnerRepository;
import com.baserent.domain.owner.ImmutableOwner;
import com.baserent.domain.owner.Owner;
import com.baserent.jooq.baserent.tables.OWNER;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import org.jooq.DSLContext;

@Singleton
public class JooqOwnerRepository implements OwnerRepository {

    @Inject
    private DSLContext context;
    @Override
    public Owner findByEmail(String email) {
        return null;
    }

    @Override
    public Owner save(Owner owner) {
        var result = context.insertInto(OWNER.OWNER)
                .set(context.newRecord(OWNER.OWNER, owner))
                .returning()
                .fetchOne();
        return toDomain(result);
    }

    private Owner toDomain(com.baserent.jooq.baserent.tables.records.OWNER result) {
        return ImmutableOwner.builder()
                .firstName(result.getValue(OWNER.OWNER.FIRST_NAME))
                .lastName(result.getValue(OWNER.OWNER.LAST_NAME))
                .id(result.getValue(OWNER.OWNER.ID))
                .email(result.getValue(OWNER.OWNER.EMAIL))
                .build();
    }
}
