package com.service.feign.servicefeign.fallback;

import com.service.feign.servicefeign.service.HelloFeignService;

/**
 * @author xiaorong.fu
 * @version 1.0
 * @ClassName ServiceClientFallBack
 * @Description feign调用其他微服务，熔断配置
 * @date 2019/12/27 17:14
 **/
public class ServiceClientFallBack implements HelloFeignService {

    @Override
    public String helloToClient(String name) {
        return "Sorry "+name +",our service-client service has down.";
    }
}
