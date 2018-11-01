package com.nsk.improve.springcloud.eurekaserverconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 高可用分布式配置中心
 *
 * @author niusk
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerConfigApplication.class, args);
    }
}
