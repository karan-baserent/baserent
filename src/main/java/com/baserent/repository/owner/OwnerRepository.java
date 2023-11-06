package com.baserent.repository.owner;

import com.baserent.entity.owner.Owner;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Integer> {
}
