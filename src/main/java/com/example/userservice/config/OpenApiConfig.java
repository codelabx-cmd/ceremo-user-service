package com.example.userservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    public OpenAPI userServiceOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Ceremo User Service")
                                .version("1.0")
                                .description("User management APIs")
                );
    }
}
