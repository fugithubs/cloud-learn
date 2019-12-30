package com.service.ribbon.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaorong.fu
 * @version 1.0
 * @ClassName HelloService
 * @Description TODO
 * @date 2019/12/27 14:43
 **/
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String helloService(String name) {
        return restTemplate.getForObject("http://SERVICE-CLIENT/hi?name=" + name, String.class);
    }

    private String hiError(String name){
        return "hi "+name+", we are so sorry,our service has down.";
    }
}
