package com.service.WasteManagerService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@OpenAPIDefinition(
		info = @Info(
				title = "WASTE MANAGER SERVICE GENERATOR MICROSERVICE",
				description = "Microservice api to generate crud for WasteManagerService",
				version = "1.0.0"
		)
)
public class WasteManagerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WasteManagerServiceApplication.class, args);
	}

}
