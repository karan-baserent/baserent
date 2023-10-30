package com.baserent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public class Prediction {
    @JsonProperty("structured_formatting")
    private List<StructuredFormatting> predictions;

    public List<StructuredFormatting> getPredictions() {
        return predictions;
    }

    public void setPredictions(List<StructuredFormatting> predictions) {
        this.predictions = predictions;
    }

    @Override
    public String toString() {
        return "Prediction{" +
                "structuredFormatting=" + predictions +
                '}';
    }
}
