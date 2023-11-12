package com.baserent.infrastructure.dto.outgoing.owner;

import io.micronaut.serde.annotation.Serdeable;
import org.immutables.value.Value;

@Serdeable
@Value.Immutable
public abstract class DashboardDto {
    public abstract String id();
}
