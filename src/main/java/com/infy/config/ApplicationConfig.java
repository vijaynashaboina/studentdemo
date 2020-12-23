package com.infy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {
	
	private static final String LICENSE_TEXT="License";
	
	private static final String TITLE="Student API";
	
	private static final String DISCRIPTION="Rest API for Student";
	
	private static final String VERSION="2.0";
	
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				. build()
				.apiInfo(metaDat());
	}
	
	
	public ApiInfo metaDat() {
		return new ApiInfoBuilder()
					.title(TITLE)
					.license(LICENSE_TEXT)
					.description(DISCRIPTION)
					.version(VERSION)
					.build();
	}

}
