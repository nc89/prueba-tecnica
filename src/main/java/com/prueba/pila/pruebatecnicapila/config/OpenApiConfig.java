package com.prueba.pila.pruebatecnicapila.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * Ajustes para la documentacion con swagger y OpenApi.
 * @author nicolas
 *
 */
@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI openApi() {

	    Info info = new Info()
	            .title("API para prueba tecnica de pila")
	            .version("0.0.1")
	            .description("Esta API expone los servicios para operaciones sobre la prueba tecnica.");
	    
	    return new OpenAPI().info(info);
		
	}
	
}
