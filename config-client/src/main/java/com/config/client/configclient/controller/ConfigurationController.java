package com.config.client.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaorong.fu
 * @version 1.0
 * @ClassName ConfigurationController
 * @Description TODO
 * @date 2020/1/8 14:09
 **/
@RestController
@RefreshScope
public class ConfigurationController {

    @Value("${foo}")
    String foo;

    @RequestMapping(value = "/hi")
    public String hiConfigClient() {
        return foo;
    }
}
