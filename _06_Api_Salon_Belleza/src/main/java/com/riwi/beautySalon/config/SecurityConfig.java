package com.riwi.beautySalon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // Anotación para configurar Spring Security
public class SecurityConfig {
    // Delcarar rutas publicas
    private final String[] PUBLIC_RESOURCES = { "services/public/get", "/auth/**" };

    // @Bean -> Esta anotación le indica a SpringBoot que el objeto retornado por el
    // metodo debe ser registrado como un bean en el contexto de la app
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authReq -> authReq.requestMatchers(PUBLIC_RESOURCES)
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .build();
        return null;
    }
}
