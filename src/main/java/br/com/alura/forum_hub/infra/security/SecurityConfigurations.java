package br.com.alura.forum_hub.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/cursos").permitAll()
                        .requestMatchers(HttpMethod.GET, "/cursos").permitAll()
                        .requestMatchers(HttpMethod.GET, "/cursos/{id}").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/cursos").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/cursos/{id}").permitAll()
                        .anyRequest().authenticated()
                )
                .build();
    }
}
