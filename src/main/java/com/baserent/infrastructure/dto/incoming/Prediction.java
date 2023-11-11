package com.baserent.infrastructure.dto.incoming;

import com.baserent.infrastructure.dto.outgoing.AutoCompleteSuggestion;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class Prediction {
    @JsonProperty("structured_formatting")
    private StructuredFormatting structuredFormatting;

    @JsonProperty("place_id")
    private String placeId;

    public StructuredFormatting getStructuredFormatting() {
        return structuredFormatting;
    }

    public void setStructuredFormatting(StructuredFormatting structuredFormatting) {
        this.structuredFormatting = structuredFormatting;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public AutoCompleteSuggestion toAutoCompleteSuggestion() {
        AutoCompleteSuggestion suggestion = structuredFormatting.toAutoCompleteSuggestion();
        suggestion.setPlaceId(placeId);
        return suggestion;
    }
}
