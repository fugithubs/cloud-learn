package com.zipkin.client.miya.zipkinclientmiya;

import brave.sampler.Sampler;
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
public class ZipkinClientMiyaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinClientMiyaApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
