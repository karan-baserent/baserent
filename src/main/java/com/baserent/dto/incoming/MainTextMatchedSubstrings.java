package com.baserent.dto.incoming;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class MainTextMatchedSubstrings {
    private int length;
    private int offset;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public com.baserent.dto.outgoing.MainTextMatchedSubstrings mainTextMatchedSubstrings() {
        return new com.baserent.dto.outgoing.MainTextMatchedSubstrings(length, offset);
    }
}
