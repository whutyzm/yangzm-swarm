package com.yangzm.ums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * description ()
 *
 * @author create by yangzm
 * @date 2023/3/12
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class UmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(UmsApplication.class, args);
    }
}
