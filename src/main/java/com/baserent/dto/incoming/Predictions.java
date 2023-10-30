package com.baserent.dto.incoming;

import com.baserent.dto.incoming.outgoing.SearchResponse;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Serdeable
public class Predictions {
    private List<Prediction> predictions;

    public List<Prediction> getPredictions() {
        return predictions;
    }

    public void setPredictions(List<Prediction> predictions) {
        this.predictions = predictions;
    }

    public SearchResponse toSearchResponse() {
        return new SearchResponse(predictions.stream()
                .map(Prediction::toAutoCompleteSuggestion)
                .collect(toList()));
    }
}
