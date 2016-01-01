package com.stenhouse.discovery.model;

/**
 * Created by jason on 1/1/16.
 */
public class Message {

    private String value;

    public Message(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
}
