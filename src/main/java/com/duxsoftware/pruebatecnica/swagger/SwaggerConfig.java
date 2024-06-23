package com.duxsoftware.pruebatecnica.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    String schemeName = "bearerAuth";
    String bearerFormat = "JWT";
    String scheme = "bearer";

    @Bean
    public OpenAPI caseOpenAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                        .addList(schemeName)).components(new Components()
                        .addSecuritySchemes(
                                schemeName, new SecurityScheme()
                                        .name(schemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .bearerFormat(bearerFormat)
                                        .in(SecurityScheme.In.HEADER)
                                        .scheme(scheme)
                        )
                )
                .info(new Info()
                        .title("Documentación para challenge de DUX")
                        .description(
                                "Se puede visualizar cada uno de los endpoints.\n"
                                        + "Para poder probar los endpoints primero necesita loguearse.\n"
                                        + "Usuario: test\n"
                                        + "Contraseña: 12345")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Leandro Calvet")
                                .email("leandrocalvet14@gmail.com"))
                )
                .addServersItem(new Server()
                        .description("LOCAL ENV")
                        .url("http://localhost:8080")
                );
    }
}
