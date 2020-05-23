package com.ecloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication    //    spring-boot启动注解
@EnableDiscoveryClient    //    eurekaClient注解
@EnableScheduling
public class SpringcloudClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudClientApplication.class, args);
	}

}
