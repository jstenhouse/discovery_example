package com.stenhouse.discovery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.boon.etcd.ClientBuilder;
import org.boon.etcd.Etcd;
import org.boon.etcd.Response;
import org.boon.etcd.exceptions.ConnectionException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;

/**
 * Created by jason on 12/31/15.
 */
@SpringBootApplication
public class Application {

    // accessible by docker link set in /etc/hosts
    private final static URI ETCD_HOST_URI = URI.create("http://etcd:4001");

    private Log log = LogFactory.getLog(Application.class);

    @Value("${SERVICE_NAME:unknown}")
    private String serviceName;

    @Value("${SERVER_PORT:8080}")
    private int port;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init() {
        registerService();
    }

    private void registerService() {
        try {
            Etcd etcd = getEtcdClient();

            String serviceAddress = InetAddress.getLocalHost().getHostAddress();
            String serviceUri = "http://" + serviceAddress + ":" + port;

            log.info("Service host: " + serviceUri);

            Response response = etcd.set("service/" + serviceName, serviceUri);

            log.info("Etcd Response: " + response.toString());
        }
        catch (UnknownHostException | ConnectionException e) {
            log.error(e);
        }
    }

    private Etcd getEtcdClient() {
        log.info("Etcd Host: " + ETCD_HOST_URI);

        return ClientBuilder.builder().hosts(ETCD_HOST_URI).createClient();
    }
}
