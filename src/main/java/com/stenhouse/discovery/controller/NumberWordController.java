package com.stenhouse.discovery.controller;

import com.stenhouse.discovery.model.NumberWord;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by jason on 1/3/16.
 */
@RestController
public class NumberWordController {

    @RequestMapping(value="/number-word", method=GET)
    public NumberWord getNumberWord() {
        return new NumberWord(42, "liminal");
    }
}
