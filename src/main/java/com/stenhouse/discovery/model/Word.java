package com.stenhouse.discovery.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

/**
 * Created by jason on 1/3/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Word {

    private String value;

    public Word() {}

    public Word(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("value", value)
                .toString();
    }

}
