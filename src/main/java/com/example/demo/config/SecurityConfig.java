package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Tắt CSRF (vì mình làm REST API nên không cần cái này, để tránh lỗi khi POST/PUT)
                .csrf(csrf -> csrf.disable())

                // 2. Cấu hình quyền truy cập
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll() // Cho phép tất cả các API bắt đầu bằng /api/ được truy cập tự do
                        .anyRequest().authenticated()           // Các yêu cầu khác vẫn phải đăng nhập
                );

        return http.build();
    }
}