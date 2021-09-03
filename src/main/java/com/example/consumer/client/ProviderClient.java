package com.example.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "provider-service", fallback = ProviderClientFallback.class)
public interface ProviderClient {
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    String ping();
}

@Component
class ProviderClientFallback implements ProviderClient {

    @Override
    public String ping() {
        return "Error";
    }
}
