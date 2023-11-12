package com.baserent.controllers;

import io.micronaut.http.annotation.Error;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

public abstract class ParentController {
    @Inject
    private Validator validator;

    public <T> void validate(T object) throws ConstraintViolationException {
        var violations = validator.validate(object);
        if (violations.size() > 0) {
            throw new ConstraintViolationException(violations);
        }
    }

}
