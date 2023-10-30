package com.baserent.dto.incoming.outgoing;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public class SearchResponse {
    private List<AutoCompleteSuggestion> suggestions;

    public SearchResponse(List<AutoCompleteSuggestion> suggestions) {
        this.suggestions = suggestions;
    }

    public List<AutoCompleteSuggestion> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<AutoCompleteSuggestion> suggestions) {
        this.suggestions = suggestions;
    }
}
