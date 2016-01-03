package com.stenhouse.discovery.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

/**
 * Created by jason on 1/3/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NumberWord {

    private int number;
    private String word;

    public NumberWord() {}

    public NumberWord(final int number, final String word) {
        this.number = number;
        this.word = word;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("number", number)
                .add("word", word)
                .toString();
    }
}
