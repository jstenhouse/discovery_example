package com.stenhouse.discovery.controller;

import com.stenhouse.discovery.model.Number;
import com.stenhouse.discovery.model.NumberWord;
import com.stenhouse.discovery.model.Word;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by jason on 1/3/16.
 */
@RestController
public class NumberWordController {

    @RequestMapping(value="/number-word", method=GET)
    public NumberWord getNumberWord() {
        final RestTemplate restTemplate = new RestTemplate();

        Number number  = restTemplate.getForObject("http://localhost:8080", Number.class);
        Word word = restTemplate.getForObject("http://localhost:8081", Word.class);

        return new NumberWord(number.getValue(), word.getValue());
    }
}
