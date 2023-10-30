package com.baserent.dto.incoming.outgoing;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class AutoCompleteSuggestion {
    private String suggestion;

    public AutoCompleteSuggestion(String mainText, String secondaryText) {
        this.suggestion = String.format("%s,%s", mainText, secondaryText);
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }
}
