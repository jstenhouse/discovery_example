package com.stenhouse.discovery.controller;

import com.stenhouse.discovery.model.Message;
import org.boon.etcd.ClientBuilder;
import org.boon.etcd.Etcd;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by jason on 1/3/16.
 */
@RestController
public class ServicesController {

    @Value("${ETCD_PORT_4001_TCP_ADDR:0.0.0.0}")
    private String etcdHost;

    @RequestMapping(value="/services", method=GET)
    public List<Message> getServices() {

        URI etcdUri = URI.create(etcdHost + ":4001");
        Etcd etcd = ClientBuilder.builder().hosts(etcdUri).createClient();

        final RestTemplate restTemplate = new RestTemplate();

        Message ping  = restTemplate.getForObject("http://localhost:8080/ping", Message.class);
        Message pong = restTemplate.getForObject("http://localhost:8081/pong", Message.class);

        return Arrays.asList(new Message("foo"), new Message("bar"));
    }
}
