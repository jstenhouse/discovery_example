package com.stenhouse.discovery.controller;

import com.stenhouse.discovery.model.Message;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.boon.etcd.Etcd;
import org.boon.etcd.Response;
import org.boon.etcd.exceptions.ConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final static Log log = LogFactory.getLog(ServicesController.class);

    @Autowired
    private Etcd etcdClient;

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value="/services", method=GET)
    public List<Message> getServices() {

        String pingServiceUri = getPingServiceUri();
        String pongServiceUri = getPongServiceUri();

        log.info("Ping Service: " + getPingServiceUri());
        log.info("Pong Service: " + getPongServiceUri());

        Message ping = restTemplate.getForObject(pingServiceUri + "/ping", Message.class);
        Message pong = restTemplate.getForObject(pongServiceUri + "/pong", Message.class);

        return Arrays.asList(ping, pong);
    }

    private String getPingServiceUri() {
        return getServiceUri("ping");
    }

    private String getPongServiceUri() {
        return getServiceUri("pong");
    }

    private String getServiceUri(final String serviceName) {
        String serviceUri = "unknown";

        try {
            Response response = etcdClient.get("service/" + serviceName);
            serviceUri = response.node().getValue();
        }
        catch (ConnectionException e) {
            log.error(e);
        }

        return serviceUri;
    }
}
