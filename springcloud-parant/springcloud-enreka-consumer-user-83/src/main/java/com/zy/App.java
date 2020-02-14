package com.zy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		System.out.println("启动消费端...83.......");
		SpringApplication.run(App.class, args);
		
		System.out.println("消费端....83......启动成功");
	}
	
	@Bean//加载RestTemplate 
	@LoadBalanced //ribbon实现负载均衡，需要加入ribbon依赖
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
