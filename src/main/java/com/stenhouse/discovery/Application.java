package com.stenhouse.discovery;

import com.stenhouse.discovery.hystrix.EtcdSetCommand;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.boon.etcd.ClientBuilder;
import org.boon.etcd.Etcd;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;

/**
 * Created by jason on 12/31/15.
 */
@SpringBootApplication
public class Application {

    private final static Log log = LogFactory.getLog(Application.class);

    // accessible by docker link set in /etc/hosts
    private final static URI ETCD_HOST_URI = URI.create("http://etcd:4001");

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

    @Bean
    public Etcd etcdClient() {
        log.info("Etcd Host: " + ETCD_HOST_URI);

        return ClientBuilder.builder().hosts(ETCD_HOST_URI).createClient();
    }

    private void registerService() {
        try {
            String serviceAddress = InetAddress.getLocalHost().getHostAddress();
            String serviceUri = "http://" + serviceAddress + ":" + port;

            log.info("Service host: " + serviceUri);

            EtcdSetCommand setCommand = new EtcdSetCommand(etcdClient(), serviceName, serviceUri);
            setCommand.execute();
        }
        catch (UnknownHostException e) {
            log.error(e);
        }
    }
}
