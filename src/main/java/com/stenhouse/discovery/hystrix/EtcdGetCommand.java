package com.stenhouse.discovery.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.boon.etcd.Etcd;
import org.boon.etcd.Response;

/**
 * Created by jason on 1/10/16.
 */
public class EtcdGetCommand extends HystrixCommand<String> {

    private final static Log log = LogFactory.getLog(EtcdGetCommand.class);

    private final Etcd client;
    private final String serviceName;

    public EtcdGetCommand(final Etcd client, final String serviceName) {
        super(HystrixCommandGroupKey.Factory.asKey("EtcdServiceDiscovery"));

        this.client = client;
        this.serviceName = serviceName;
    }

    @Override
    protected String run() throws Exception {
        Response response = client.get("service/" + serviceName);

        return response.node().getValue();
    }

    @Override
    protected String getFallback() {
        return "unknown!";
    }
}
