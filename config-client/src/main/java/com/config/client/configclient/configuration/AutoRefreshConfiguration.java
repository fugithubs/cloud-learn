package com.config.client.configclient.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author xiaorong.fu
 * @version 1.0
 * @ClassName AutoRefreshConfiguration
 * @Description 自动更新从git中的配置文件信息
 * @date 2020/1/8 11:42
 **/
@Component
public class AutoRefreshConfiguration {

    @Autowired
    private ContextRefresher contextRefresher;

    @Value("${server.port}")
    private String serverPort;

    @Scheduled(fixedDelayString = "2000")
    public void autoRefreshConfig() {
        // TODO 多实例的情况会导致其中一个实例注册不到eureka中
        contextRefresher.refresh();
    }
}
