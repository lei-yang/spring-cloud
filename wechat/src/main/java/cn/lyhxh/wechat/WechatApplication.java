package cn.lyhxh.wechat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "cn.lyhxh.wechat.dao")
public class WechatApplication {

	public static void main(String[] args) {
//		SpringApplication.run(WechatApplication.class, args);
		new SpringApplicationBuilder(WechatApplication.class).web(true).run(args);
	}
}
