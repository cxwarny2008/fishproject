package com.tyb.fishcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class FishCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(FishCloudApplication.class, args);
    }
}
