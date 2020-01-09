package com.zipkin.client.miya.zipkinclientmiya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author xiaorong.fu
 * @version 1.0
 * @ClassName ServiceMiyaController
 * @Description TODO
 * @date 2020/1/9 15:17
 **/
@RestController
public class ServiceMiyaController {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger LOGGER = Logger.getLogger(ServiceMiyaController.class.getName());

    @RequestMapping("/hi")
    public String home() {
        LOGGER.log(Level.INFO, "hi is being called");
        return "hi i'm service-miya!";
    }

    @RequestMapping("/miya")
    public String info() {
        LOGGER.log(Level.INFO, "info is being called");
        return restTemplate.getForObject("http://localhost:9412/info", String.class);
    }
}
