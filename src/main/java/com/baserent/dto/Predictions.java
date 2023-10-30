package com.baserent.dto;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public class Predictions {
    private List<Prediction> predictions;

    public List<Prediction> getPredictions() {
        return predictions;
    }

    public void setPredictions(List<Prediction> predictions) {
        this.predictions = predictions;
    }
}
