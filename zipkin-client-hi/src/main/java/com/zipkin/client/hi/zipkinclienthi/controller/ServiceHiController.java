package com.zipkin.client.hi.zipkinclienthi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author xiaorong.fu
 * @version 1.0
 * @ClassName ServiceHiController
 * @Description TODO
 * @date 2020/1/9 15:44
 **/
@RestController
public class ServiceHiController {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger LOGGER = Logger.getLogger(ServiceHiController.class.getName());

    @RequestMapping("/hi")
    public String callHome() {
        LOGGER.log(Level.INFO, "calling trace service-hi");
        return restTemplate.getForObject("http://localhost:9413/miya", String.class);
    }

    @RequestMapping("/info")
    public String info() {
        LOGGER.log(Level.INFO, "calling trace service-hi");
        return "i'm service-hi";

    }
}
