package com.example.gate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 网关服务
 *
 * @author fengshuonan
 * @Date 2017/11/10 上午11:24
 */
@EnableZuulProxy
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.iciyun.adi.microframe")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class,scanBasePackages = "com.iciyun.adi.microframe")
public class GateApplication extends WebMvcConfigurerAdapter{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
        this._configCorsParams(registry.addMapping("/**"));
	}

    private void _configCorsParams(CorsRegistration corsRegistration) {
        corsRegistration.allowedOrigins("*")
                .allowedMethods(HttpMethod.GET.name(), HttpMethod.HEAD.name(), HttpMethod.POST.name(), HttpMethod.PUT.name(), HttpMethod.DELETE.name())
                .allowedHeaders("*")
                .exposedHeaders("Set-Cookie")
                .allowCredentials(true)
                .maxAge(1800L);
    }

	public static void main(String[] args) {
		SpringApplication.run(GateApplication.class, args);
	}
}
