package com.baserent.infrastructure.dto.incoming.owner;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.validation.Validated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.immutables.value.Value;



@JsonDeserialize(as = ImmutableOwnerSignUpRequestDto.class)
@Value.Immutable
//@Value.Style(passAnnotations = {Introspected.class, NotBlank.class})
@Introspected
public interface OwnerSignUpRequestDto {
    @NotBlank
    @Email
    String getEmail();

    @NotBlank
    String getPassword();

    @NotBlank
    String getFirstName();

    @NotBlank
    String getLastName();
}
