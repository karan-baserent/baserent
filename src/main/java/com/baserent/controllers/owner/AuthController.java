package com.baserent.controllers.owner;

import com.baserent.api.OwnerApi;
import com.baserent.infrastructure.dto.incoming.owner.OwnerSignInRequestDto;
import com.baserent.infrastructure.dto.incoming.owner.OwnerSignUpRequestDto;
import com.baserent.infrastructure.dto.outgoing.owner.OwnerSignUpResponseDto;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

@Controller("/owner")
public class AuthController {
    @Inject
    private OwnerApi ownerApi;

    @Post("/sign-up")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Secured(SecurityRule.IS_ANONYMOUS)
    public MutableHttpResponse<OwnerSignUpResponseDto> signUp(HttpRequest<OwnerSignUpRequestDto> request){
        OwnerSignUpRequestDto ownerSignUpRequestDto = request.getBody().orElseThrow();
        OwnerSignUpResponseDto ownerSignUpResponseDto = ownerApi.save(ownerSignUpRequestDto);
        return HttpResponse.ok(ownerSignUpResponseDto);
    }
    @Post("/sign-in")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Secured(SecurityRule.IS_AUTHENTICATED)
    public void signIn(HttpRequest<OwnerSignInRequestDto> request){
        OwnerSignInRequestDto ownerSignInRequestDto = request.getBody().orElseThrow();
    }
}
