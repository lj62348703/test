package com.zy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.zy.repository")//扫描data-jpa组件
@EntityScan("com.zy.entity")//扫描实体类
@EnableEurekaClient
//@EnableDiscoveryClient//让注册中心能够发现，扫描到该服务。
public class App {
	public static void main(String[] args) {
		System.out.println("启动提供端...8002.......");
		SpringApplication.run(App.class, args);
		
		System.out.println("提供端....8002......启动成功");
	}
}
