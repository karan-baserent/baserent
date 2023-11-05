package com.baserent.authentication;

import jakarta.inject.Singleton;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import org.reactivestreams.Publisher;
import io.micronaut.core.annotation.Nullable;

@Singleton
public class AuthenticationProviderUserPassword implements AuthenticationProvider<HttpRequest<?>>{
    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        System.out.println(authenticationRequest.getIdentity());
        return null;
    }
}
