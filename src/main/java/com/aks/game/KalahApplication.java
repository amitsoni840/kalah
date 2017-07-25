/**
 * 
 */
package com.aks.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Amit Soni
 *
 */
@Configuration
@EnableSwagger2
@SpringBootApplication
public class KalahApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(KalahApplication.class, args);
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.aks.game")).paths(PathSelectors.any()).build()
				.apiInfo(metaData());
	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("Kalah Game REST API", "REST API for playing Kalah game", "1.0",
				"Terms of service", new Contact("Amit Soni", "", "amitsoni840@gmail.com"), "Version 1.0", "");
		return apiInfo;
	}
}
