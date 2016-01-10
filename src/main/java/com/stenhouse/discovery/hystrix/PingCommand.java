package com.stenhouse.discovery.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.stenhouse.discovery.model.Message;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jason on 1/10/16.
 */
public class PingCommand extends HystrixCommand<Message> {

    private final static RestTemplate REST_TEMPLATE = new RestTemplate();

    private final String serviceUri;

    public PingCommand(final String serviceUri) {
        super(HystrixCommandGroupKey.Factory.asKey("Ping"));

        this.serviceUri = serviceUri;
    }

    @Override
    protected Message run() throws Exception {
        return REST_TEMPLATE.getForObject(serviceUri + "/ping", Message.class);
    }
}
