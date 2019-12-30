package com.service.ribbon.serviceribbon.controller;

import com.service.ribbon.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaorong.fu
 * @version 1.0
 * @ClassName HelloController
 * @Description TODO
 * @date 2019/12/27 14:46
 **/
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.helloService(name);
    }
}
