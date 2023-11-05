package com.baserent.controllers.owner;

import com.baserent.dto.incoming.owner.OwnerSignUpRequestDto;
import com.baserent.dto.outgoing.owner.OwnerSignUpResponseDto;
import com.baserent.service.owner.OwnerService;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

@Controller("/owner")
@Secured(SecurityRule.IS_ANONYMOUS)
public class AuthController {
    @Inject
    private OwnerService ownerService;
    @Post("/sign-up")
    @Produces(MediaType.APPLICATION_JSON)
    public MutableHttpResponse<OwnerSignUpResponseDto> signUp(HttpRequest<?> request){
        OwnerSignUpRequestDto ownerSignUpRequestDto = request.getBody(OwnerSignUpRequestDto.class).orElseThrow();
        OwnerSignUpResponseDto ownerSignUpResponseDto = ownerService.createOwner(ownerSignUpRequestDto);
        return HttpResponse.ok(ownerSignUpResponseDto);
    }
    @Post("/sign-in")
    public void signIn(){

    }
}
