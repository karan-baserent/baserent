package com.baserent.dto.incoming;

import com.baserent.dto.outgoing.AutoCompleteSuggestion;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Serdeable
public class StructuredFormatting {
    @JsonProperty("main_text")
    private String mainText;
    @JsonProperty("secondary_text")
    private String secondaryText;

    @JsonProperty("main_text_matched_substrings")
    private List<MainTextMatchedSubstrings> mainTextMatchedSubstrings;

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

    public List<MainTextMatchedSubstrings> getMainTextMatchedSubstrings() {
        return mainTextMatchedSubstrings;
    }

    public void setMainTextMatchedSubstrings(List<MainTextMatchedSubstrings> mainTextMatchedSubstrings) {
        this.mainTextMatchedSubstrings = mainTextMatchedSubstrings;
    }

    public AutoCompleteSuggestion toAutoCompleteSuggestion() {
        return new AutoCompleteSuggestion(mainText, secondaryText, mainTextMatchedSubstrings.stream().map(MainTextMatchedSubstrings::mainTextMatchedSubstrings).collect(toList()));
    }
}
