package com.zipkin.client.hi.zipkinclienthi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaorong.fu
 */
@SpringBootApplication
@EnableEurekaClient
public class ZipkinClientHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinClientHiApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
