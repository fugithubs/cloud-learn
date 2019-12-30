package com.service.feign.servicefeign.controller;

import com.service.feign.servicefeign.service.HelloFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaorong.fu
 * @version 1.0
 * @ClassName HelloFeignController
 * @Description TODO
 * @date 2019/12/27 15:45
 **/
@RestController
public class HelloFeignController {

    @Autowired
    private HelloFeignService helloFeignService;

    @GetMapping("/hi")
    public String sayHi(@RequestParam("name") String name) {
        return helloFeignService.helloToClient(name);
    }
}
