package com.stenhouse.discovery.controller;

import com.stenhouse.discovery.model.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by jason on 1/1/16.
 */
@RestController
public class GoodbyeController {

    @RequestMapping(value="/goodbye-world", method=GET)
    public Message sayGoodbye() {
        return new Message("Goodbye, World!");
    }
}
