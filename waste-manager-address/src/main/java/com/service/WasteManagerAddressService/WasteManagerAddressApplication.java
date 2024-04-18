package com.service.WasteManagerAddressService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(
		info = @Info(
				title = "WASTE MANAGER ADDRESS GENERATOR MICROSERVICE",
				description = "Microservice api to generate crud for WasteManagerAddress",
				version = "1.0.0"
		)
)
public class WasteManagerAddressApplication {

	public static void main(String[] args) {
		SpringApplication.run(WasteManagerAddressApplication.class, args);
	}

}
