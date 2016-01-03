package com.stenhouse.discovery.controller;

import com.stenhouse.discovery.model.Word;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by jason on 1/3/16.
 */
@RestController
public class WordController {

    @RequestMapping(value="/word", method=GET)
    public Word getWord() {
        return new Word("liminal");
    }
}
