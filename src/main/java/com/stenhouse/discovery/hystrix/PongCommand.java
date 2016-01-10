package com.stenhouse.discovery.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.stenhouse.discovery.model.Message;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jason on 1/10/16.
 */
public class PongCommand extends HystrixCommand<Message> {

    private final static RestTemplate REST_TEMPLATE = new RestTemplate();

    private final String serviceUri;

    public PongCommand(final String serviceUri) {
        super(HystrixCommandGroupKey.Factory.asKey("Pong"));

        this.serviceUri = serviceUri;
    }

    @Override
    protected Message run() throws Exception {
        return REST_TEMPLATE.getForObject(serviceUri + "/pong", Message.class);
    }
}
