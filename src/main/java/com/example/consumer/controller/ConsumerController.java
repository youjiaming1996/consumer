package com.example.consumer.controller;

import com.example.consumer.client.ProviderClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ConsumerController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ProviderClient providerClient;


    @GetMapping("/service")
    public Object getClient() {
        return discoveryClient.getServices();
    }

    @GetMapping("/instance")
    public List<ServiceInstance> getInstance(String instanceId) {
        return discoveryClient.getInstances(instanceId);
    }

    @GetMapping("/ping")
    public String ping() {
        return providerClient.ping();
    }


}
