package com.baserent.infrastructure.dto.outgoing;

import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public class AutoCompleteSuggestion {
    private String suggestion;
    private String placeId;

    private List<MainTextMatchedSubstrings> mainTextMatchedSubstrings;

    public AutoCompleteSuggestion(String mainText,
                                  String secondaryText,
                                  List<MainTextMatchedSubstrings> mainTextMatchedSubstrings) {
        this.suggestion = String.format("%s,%s", mainText, secondaryText);
        this.mainTextMatchedSubstrings = mainTextMatchedSubstrings;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public List<MainTextMatchedSubstrings> getMainTextMatchedSubstrings() {
        return mainTextMatchedSubstrings;
    }

    public void setMainTextMatchedSubstrings(List<MainTextMatchedSubstrings> mainTextMatchedSubstrings) {
        this.mainTextMatchedSubstrings = mainTextMatchedSubstrings;
    }
}
