package com.ecloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication    //    spring-boot启动注解
@EnableEurekaServer       //    eureka组件服务注解
public class SpringcloudServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudServerApplication.class, args);
	}

}
