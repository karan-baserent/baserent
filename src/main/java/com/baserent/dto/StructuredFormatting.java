package com.baserent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class StructuredFormatting {
    @JsonProperty("main_text")
    private String mainText;
    @JsonProperty("secondary_text")
    private String secondaryText;

    public String getMainText() {
        return mainText;
    }

    public String getSecondaryText() {
        return secondaryText;
    }

    public void setSecondaryText(String secondaryText) {
        this.secondaryText = secondaryText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    @Override
    public String toString() {
        return "StructuredFormatting{" +
                "mainText='" + mainText + '\'' +
                ", secondaryText='" + secondaryText + '\'' +
                '}';
    }
}
