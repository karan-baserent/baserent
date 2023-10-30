package com.baserent.controllers;

import com.baserent.clients.GooglePlacesApiClient;
import com.baserent.dto.Prediction;
import com.baserent.dto.Predictions;
import com.baserent.util.AwsUtil;
import io.micronaut.context.annotation.Property;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import org.reactivestreams.Publisher;

@Controller("/search")
public class SearchController {
    @Property(name = "aws.secrets.google-places-api-key")
    private String googlePlacesApiKey;

    private final GooglePlacesApiClient googlePlacesApiClient;

    public SearchController(GooglePlacesApiClient googlePlacesApiClient) {
        this.googlePlacesApiClient = googlePlacesApiClient;
    }

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<Predictions> search(HttpRequest<?> request) {
        String searchTerm = request.getParameters().getFirst("address").orElseThrow();
        String apiKey = AwsUtil.getValue(googlePlacesApiKey);
        Predictions response = googlePlacesApiClient.getAutoCompleteResults(searchTerm, apiKey);
        return HttpResponse.ok(response);
    }
}