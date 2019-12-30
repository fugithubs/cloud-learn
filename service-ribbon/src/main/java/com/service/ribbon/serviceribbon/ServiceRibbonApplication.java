package com.service.ribbon.serviceribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaorong.fu
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class ServiceRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonApplication.class, args);
    }

    /**
     * 向IOC注入一个bean:restTemplate
     * @return
     */
    @Bean
    @LoadBalanced /* 通过ribbon实现客户端的负载均衡功能 */
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
