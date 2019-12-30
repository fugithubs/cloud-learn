package com.service.feign.servicefeign.service;

import com.service.feign.servicefeign.fallback.ServiceClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-client", fallback = ServiceClientFallBack.class)
public interface HelloFeignService {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String helloToClient(@RequestParam("name") String name);
}
