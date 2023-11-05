package com.baserent.controllers.owner;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Controller("/owner")
@Secured(SecurityRule.IS_ANONYMOUS)
public class AuthController {
    @Post("/sign-up")
    public void signUp(){

    }
    @Post("/sign-in")
    public void signIn(){

    }
}
