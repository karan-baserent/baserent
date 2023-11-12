package com.baserent.controllers.owner;

import com.baserent.api.OwnerApi;
import com.baserent.authentication.AuthenticationRoles;
import com.baserent.controllers.ParentController;
import com.baserent.infrastructure.dto.incoming.owner.OwnerSignInRequestDto;
import com.baserent.infrastructure.dto.incoming.owner.OwnerSignUpRequestDto;
import com.baserent.infrastructure.dto.outgoing.ImmutableErrorDto;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.http.cookie.Cookie;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.security.token.cookie.TokenCookieLoginHandler;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import org.jooq.exception.IntegrityConstraintViolationException;

import java.net.URI;
import java.util.*;

import static java.util.stream.Collectors.toMap;

@Controller("/owner")
@Secured(SecurityRule.IS_ANONYMOUS)
@Validated
public class SignUpSignInController extends ParentController {
    @Inject
    private OwnerApi ownerApi;

    @Inject
    private TokenCookieLoginHandler tokenCookieLoginHandler;

    @Post("/sign-up")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MutableHttpResponse signUp(HttpRequest<OwnerSignUpRequestDto> request){
        OwnerSignUpRequestDto ownerSignUpRequestDto = request.getBody().orElseThrow();
        validate(ownerSignUpRequestDto);
        int id;
        List<Cookie> jwtCookies = Collections.emptyList();
        try {
            id = ownerApi.save(ownerSignUpRequestDto);
            jwtCookies = tokenCookieLoginHandler.getCookies(Authentication.build(String.valueOf(id), Collections.checkedCollection(List.of(AuthenticationRoles.OWNER.toString()), String.class)),request);
        } catch (IntegrityConstraintViolationException e) {
            return HttpResponse.badRequest(ImmutableErrorDto.builder().message(e.getMessage()).build());
        }
        URI dashboardUri = URI.create(String.format("/owner/%s/dashboard", id));
        return HttpResponse.redirect(dashboardUri).headers(jwtCookies.stream().collect(toMap(Cookie::getName, Cookie::getValue)));
    }
    @Post("/sign-in")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Secured(SecurityRule.IS_AUTHENTICATED)
    public void signIn(HttpRequest<OwnerSignInRequestDto> request){
        OwnerSignInRequestDto ownerSignInRequestDto = request.getBody().orElseThrow();
    }
}
