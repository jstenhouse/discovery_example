package com.stenhouse.discovery.controller;

import com.stenhouse.discovery.model.Number;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by jason on 1/3/16.
 */
@RestController
public class NumberController {

    @RequestMapping(value="/number", method=GET)
    public Number getNumber() {
        return new Number(42);
    }
}
