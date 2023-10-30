package com.baserent.clients;

import com.baserent.dto.Prediction;
import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

@Client(id="google-places")
public interface GooglePlacesApiClient {
    @Get("/maps/api/place/autocomplete/json?types=geocode&components=country:ca&input={input}&key={key}")
    @SingleResult
    Prediction getAutoCompleteResults(@QueryValue String input,
                                      @QueryValue String key);
}
