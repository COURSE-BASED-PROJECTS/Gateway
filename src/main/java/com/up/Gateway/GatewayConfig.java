package com.up.Gateway;

import com.up.Gateway.filter.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Autowired
    private AuthFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("account-service", r -> r.path("/api/account/**").uri("http://localhost:9091"))
                .route("driver-service", r -> r.path("/api/driver/**").uri("http://localhost:9092"))
                .route("request-service", r -> r.path("/api/request/**").uri("http://localhost:9093"))
                .route("taxi-service", r -> r.path("/api/taxi/**").uri("http://localhost:9094"))
                .build();
    }

}