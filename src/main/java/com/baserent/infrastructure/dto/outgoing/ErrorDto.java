package com.baserent.infrastructure.dto.outgoing;

import io.micronaut.serde.annotation.Serdeable;
import org.immutables.value.Value;

@Serdeable
@Value.Immutable
public abstract class ErrorDto {
    abstract String message();
}
