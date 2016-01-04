package com.stenhouse.discovery.controller;

import com.stenhouse.discovery.model.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by jason on 1/3/16.
 */
@RestController
public class ServicesController {

    @RequestMapping(value="/services", method=GET)
    public List<Message> getServices() {
        final RestTemplate restTemplate = new RestTemplate();

        Message ping  = restTemplate.getForObject("http://localhost:8080/ping", Message.class);
        Message pong = restTemplate.getForObject("http://localhost:8081/pong", Message.class);

        return Arrays.asList(new Message("foo"), new Message("bar"));
    }
}
