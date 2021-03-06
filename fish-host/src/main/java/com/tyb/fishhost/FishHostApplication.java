package com.tyb.fishhost;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@ComponentScan("com.tyb.*")
@MapperScan("com.tyb.fish.mapper")
@ServletComponentScan
public class FishHostApplication {

    public static void main(String[] args) {
        SpringApplication.run(FishHostApplication.class, args);
    }
}
