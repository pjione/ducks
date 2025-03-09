package com.study.ducks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring()
                .requestMatchers("/h2-console/**")
                .requestMatchers( "/favicon.ico")
                .requestMatchers( "/error")
                .requestMatchers( "/api/docs")
                .requestMatchers( "/api/swagger-ui/**")
                .requestMatchers( "/swagger-resources/**")
                .requestMatchers( "/v3/api-docs/**");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(requests -> requests
                        .anyRequest().permitAll()
                )
                .build();
    }
}
