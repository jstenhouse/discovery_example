package com.stenhouse.discovery.controller;

import com.stenhouse.discovery.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by jason on 1/2/16.
 */
@RestController
public class SayController {

    @Value("${api.saying:Hello, World!}")
    private String saying;

    @RequestMapping(value="/say", method=GET)
    public Message say() {
        return new Message(saying);
    }
}
