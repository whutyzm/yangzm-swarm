package com.yangzm.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description ()
 *
 * @author create by yangzm
 * @date 2023/3/12
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }
}
