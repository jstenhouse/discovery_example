package com.stenhouse.discovery.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

/**
 * Created by jason on 1/3/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Number {

    private int value;

    public Number() {}

    public Number(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("value", value)
                .toString();
    }

}
