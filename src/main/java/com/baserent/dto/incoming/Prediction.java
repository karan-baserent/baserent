package com.baserent.dto.incoming;

import com.baserent.dto.incoming.outgoing.AutoCompleteSuggestion;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class Prediction {
    @JsonProperty("structured_formatting")
    private StructuredFormatting structuredFormatting;

    public StructuredFormatting getStructuredFormatting() {
        return structuredFormatting;
    }

    public void setStructuredFormatting(StructuredFormatting structuredFormatting) {
        this.structuredFormatting = structuredFormatting;
    }

    public AutoCompleteSuggestion toAutoCompleteSuggestion() {
        return structuredFormatting.toAutoCompleteSuggestion();
    }
}
