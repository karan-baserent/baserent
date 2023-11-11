package com.baserent.infrastructure.dto.outgoing.owner;

import io.micronaut.serde.annotation.Serdeable;
import org.immutables.value.Value;

@Serdeable
@Value.Immutable
public abstract class OwnerSignUpResponseDto {
    public abstract Integer getId();


    public abstract String getFirstName();


    public abstract String getLastName();


    public abstract String getEmail();


}
