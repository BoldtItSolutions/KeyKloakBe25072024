package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    @Order(-102)
    public WebMvcConfigurer corsConfig() {

        var test = new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**")
                        .allowedOrigins("http://localhost:4200", "http://localhost")

                        .allowedMethods(
                                HttpMethod.GET.name(),
                                HttpMethod.POST.name(),
                                HttpMethod.DELETE.name(),
                                HttpMethod.PUT.name(),
                                HttpMethod.OPTIONS.name()
                        )

                        .allowedHeaders(
                                HttpHeaders.CONTENT_TYPE,
                                HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS,
                                HttpHeaders.AUTHORIZATION,
                                HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS,
                                HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,
                                HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD,
                                HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN
                        )

                        .allowCredentials(true);
            }
        };

        return test;
    }
}
