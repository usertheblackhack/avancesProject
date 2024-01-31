/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author USUARIO
 */
@Configuration
public class ConfigCors 
{
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                        registry.addMapping("/api/**")
                                .allowedOrigins("http://localhost:8082")
                                .allowedMethods("GET", "POST", "PUT", "DELETE")
                                .maxAge(3600);
                }

        };
    } 
}
