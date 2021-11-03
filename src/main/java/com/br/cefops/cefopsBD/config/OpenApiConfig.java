package com.br.cefops.cefopsBD.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration

public class OpenApiConfig {
	@Bean
	public OpenAPI customOpenAPI() {
		return new  OpenAPI()
				.info(new Info()
						.title("Api CEFOPS")
						.version("v1")
						.description("Api da escola Cefops desenvolvido em java 16")
						.termsOfService("teste")
						.license(new License().name("Apache 2.0").url(""))
						);
		
	}
	

}
