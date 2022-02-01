package org.apigateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Autowired
    AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("userservice", r -> r.path("/users/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8085/users"))

                .route("authservice", r -> r.path("/auth/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8084/auth"))


                .route("profileservice", r -> r.path("/profileservice/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8083/profileservice"))
                .build();


    }

}
