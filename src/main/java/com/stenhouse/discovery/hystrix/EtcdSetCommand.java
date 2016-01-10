package com.stenhouse.discovery.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.boon.etcd.Etcd;

/**
 * Created by jason on 1/10/16.
 */
public class EtcdSetCommand extends HystrixCommand<Void> {

    private final Etcd client;
    private final String serviceName;
    private final String serviceUri;

    public EtcdSetCommand(final Etcd client, final String serviceName, final String serviceUri) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("EtcdServiceDiscovery"))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(5000)));

        this.client = client;
        this.serviceName = serviceName;
        this.serviceUri = serviceUri;
    }

    @Override
    protected Void run() throws Exception {
        client.set("service/" + serviceName, serviceUri);

        return null;
    }
}
