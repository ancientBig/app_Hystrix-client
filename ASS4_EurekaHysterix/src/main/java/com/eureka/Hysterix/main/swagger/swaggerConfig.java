package com.eureka.Hysterix.main.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestHeader;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class swaggerConfig {
	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("MA XABA, Microservice(client)-api")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}



	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Microservice client hystrix application")
				.description("The applicvation will get the list of the employees created by the 'service-hystrix' ")
				.termsOfServiceUrl("https://github.com/ancientBig/")
				.contact("alfreat@gmail.com").license("service License")
				.licenseUrl("alfreat@gmail.com").version("1.0").build();
	}

}
