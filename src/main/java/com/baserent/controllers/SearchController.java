package com.baserent.controllers;

import com.baserent.infrastructure.clients.GooglePlacesApiClient;
import com.baserent.infrastructure.dto.incoming.Predictions;
import com.baserent.infrastructure.dto.outgoing.SearchResponse;
import io.micronaut.context.annotation.Property;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.util.Map;

@Controller("/search")
@Secured(SecurityRule.IS_ANONYMOUS)
public class SearchController {
    @Property(name = "google.places-api-key")
    private String googlePlacesApiKey;

    private final GooglePlacesApiClient googlePlacesApiClient;

    public SearchController(
            GooglePlacesApiClient googlePlacesApiClient) {
        this.googlePlacesApiClient = googlePlacesApiClient;
    }

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<SearchResponse> search(HttpRequest<?> request) {
        String searchTerm = request.getParameters().getFirst("location").orElseThrow();
        System.out.println("location: " + searchTerm);
        Predictions response = googlePlacesApiClient.getAutoCompleteResults(searchTerm, googlePlacesApiKey);
        return HttpResponse.ok(response.toSearchResponse()).headers(Map.of("Access-Control-Allow-Origin", "*"));
    }
}