package com.baserent.infrastructure.clients;

import com.baserent.infrastructure.dto.incoming.Predictions;
import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

@Client(id="google-places")
public interface GooglePlacesApiClient {
    @Get("/maps/api/place/autocomplete/json?types=geocode&components=country:ca&input={input}&key={key}")
    @SingleResult
    Predictions getAutoCompleteResults(@QueryValue String input,
                                       @QueryValue String key);
}
