package com.baserent.domain.owner;

import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
public abstract class Owner {

    public abstract Optional<Integer> getId();
    public abstract String getFirstName();
    public abstract String getLastName();

    public abstract Optional<String> getPassword();

    public abstract String getEmail();



}
