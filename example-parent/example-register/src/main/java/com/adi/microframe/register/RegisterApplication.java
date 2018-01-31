package com.adi.microframe.register;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka服务治理主类
 *+
 * @author stylefeng
 * @Date 2017/7/6 23:18
 */
@SpringBootApplication
@EnableEurekaServer
public class RegisterApplication {
	public static void main(String[] args) {
		SpringApplication.run(RegisterApplication.class, args);
	}
}
