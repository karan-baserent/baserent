package com.baserent.dto.outgoing;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class MainTextMatchedSubstrings {
    private int length;
    private int offset;

    public MainTextMatchedSubstrings(int length, int offset) {
        this.length = length;
        this.offset = offset;
    }

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
}
