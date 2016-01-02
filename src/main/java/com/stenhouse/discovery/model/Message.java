package com.stenhouse.discovery.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

/**
 * Created by jason on 1/1/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

    private String value;

    public Message() {}

    public Message(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("value", value)
                .toString();
    }
}
