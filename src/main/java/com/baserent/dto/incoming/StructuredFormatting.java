package com.baserent.dto.incoming;

import com.baserent.dto.incoming.outgoing.AutoCompleteSuggestion;
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

    public AutoCompleteSuggestion toAutoCompleteSuggestion() {
        return new AutoCompleteSuggestion(mainText, secondaryText);
    }
}
