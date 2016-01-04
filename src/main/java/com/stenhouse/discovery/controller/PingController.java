package com.stenhouse.discovery.controller;

import com.stenhouse.discovery.model.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by jason on 1/3/16.
 */
@RestController
public class PingController {

    @RequestMapping(value="/ping", method=GET)
    public Message ping() {
        return new Message("ping");
    }
}
