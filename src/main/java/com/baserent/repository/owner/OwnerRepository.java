package com.baserent.repository.owner;

import com.baserent.entity.owner.Owner;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface OwnerRepository extends CrudRepository<Owner, Integer> {
}
