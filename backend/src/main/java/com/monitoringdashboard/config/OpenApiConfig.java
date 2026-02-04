package com.monitoringdashboard.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Monitoring Dashboard API",
                description = "API de gestion de monitoring avec authentification JWT",
                version = "1.0.0",
                contact = @Contact(
                        name = "klai Rayen",
                        email = "rayen.klai@binitns.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"
                )
        ),
        servers = {
                @Server(
                        description = "Environnement Local",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Environnement Production",
                        url = "https://api.monitoring-dashboard.com"
                )
        }
)
@SecurityScheme(
        name = "Bearer Authentication",
        description = "Entrez le token JWT",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}