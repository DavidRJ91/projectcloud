package com.iesemilidarder.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;


@Configuration
public class StartConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**");
            }
            @Bean
            public FreeMarkerViewResolver freemarkerViewResolver() {
                FreeMarkerViewResolver resuelve = new FreeMarkerViewResolver();
                resuelve.setCache(true);
                resuelve.setPrefix("");
                resuelve.setSuffix(".ftl");
                return resuelve;
            }
        };
    }
    }
