package com.ceragem.api.config.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	@Value("${springdoc.server-url}")
	String serverUrl;

	@Bean
	public OpenAPI openAPI(@Value("${springdoc.version}") String appVersion) {
		Info info = new Info().title("MRCRM API Server").version(appVersion).description("MRCRM API 서버입니다.");
		String[] urls = serverUrl.split(",");
		List<Server> servers = new ArrayList<>();
		for (int i = 0; i < urls.length; i++) {
			servers.add(new Server().url(urls[i]).description("MRCRM API"));
		}

		SecurityScheme securityScheme = new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer")
				.bearerFormat("JWT").in(SecurityScheme.In.HEADER).name("Authorization");

		SecurityRequirement schemaRequirement = new SecurityRequirement().addList("bearerAuth");

		return new OpenAPI().components(new Components().addSecuritySchemes("bearerAuth", securityScheme))
				.security(Arrays.asList(schemaRequirement)).info(info).servers(servers);
	}

	@Bean
	public GroupedOpenApi allApi() {
		return GroupedOpenApi.builder().group("all").packagesToScan("com.ceragem.api.crm").build();
	}

//	@Bean
//	public GroupedOpenApi asApi() {
//		return GroupedOpenApi.builder().group("as").packagesToScan("com.ceragem.api.as").build();
//	}

	@Bean
	public GroupedOpenApi crmApi() {
		return GroupedOpenApi.builder().group("crm").packagesToScan("com.ceragem.api.crm").build();
	}

//	@Bean
//	public GroupedOpenApi ctcApi() {
//		return GroupedOpenApi.builder().group("ctc").packagesToScan("com.ceragem.api.ctc").build();
//	}

//	@Bean
//	public GroupedOpenApi sapApi() {
//		return GroupedOpenApi.builder().group("sap").packagesToScan("com.ceragem.api.sap").build();
//	}
}
