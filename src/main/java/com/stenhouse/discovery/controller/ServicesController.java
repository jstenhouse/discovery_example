package com.stenhouse.discovery.controller;

import com.stenhouse.discovery.hystrix.EtcdGetCommand;
import com.stenhouse.discovery.hystrix.PingCommand;
import com.stenhouse.discovery.hystrix.PongCommand;
import com.stenhouse.discovery.model.Message;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.boon.etcd.Etcd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by jason on 1/3/16.
 */
@RestController
public class ServicesController {

    private final static Log log = LogFactory.getLog(ServicesController.class);

    @Autowired
    private Etcd etcdClient;

    @RequestMapping(value="/services", method=GET)
    public List<Message> getServices() {

        String pingServiceUri = getPingServiceUri();
        String pongServiceUri = getPongServiceUri();

        log.info("Ping Service: " + pingServiceUri);
        log.info("Pong Service: " + pongServiceUri);

        Message ping = new PingCommand(pingServiceUri).execute();
        Message pong = new PongCommand(pongServiceUri).execute();

        return Arrays.asList(ping, pong);
    }

    private String getPingServiceUri() {
        return getServiceUri("ping");
    }

    private String getPongServiceUri() {
        return getServiceUri("pong");
    }

    private String getServiceUri(final String serviceName) {
        return new EtcdGetCommand(etcdClient, serviceName).execute();
    }
}
