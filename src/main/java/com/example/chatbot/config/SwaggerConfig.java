package com.example.chatbot.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
  @Value("${swagger.server.local}")
  private String localServer;

  @Value("${swagger.server.main}")
  private String mainServer;

  @Bean
  public OpenAPI openAPI() {
    // SecurityScheme 정의 (Bearer 토큰 방식)
    SecurityScheme apiKey = new SecurityScheme()
        .type(SecurityScheme.Type.HTTP)
        .in(SecurityScheme.In.HEADER)
        .name("Authorization")
        .scheme("bearer")
        .bearerFormat("JWT");

    // SecurityRequirement 정의
    SecurityRequirement securityRequirement = new SecurityRequirement()
        .addList("Bearer Token");

    // OpenAPI 정의
    return new OpenAPI()
        .components(new Components().addSecuritySchemes("Bearer Token", apiKey))
        .addSecurityItem(securityRequirement)
        .servers(List.of(
            new io.swagger.v3.oas.models.servers.Server()
                .url(localServer)
                .description("Local Server"),
            new io.swagger.v3.oas.models.servers.Server()
                .url(mainServer)
                .description("Main 서버")
        ));
  }
}