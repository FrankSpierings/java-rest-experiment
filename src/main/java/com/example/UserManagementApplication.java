package com.example;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.example.controller", "com.example.service"})
@OpenAPIDefinition(info = @Info(title = "User Management API", version = "1.0", description = "API to manage users in memory"))
public class UserManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserManagementApplication.class, args);
    }
    
    @Bean
    CommandLineRunner runner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Beans provided by Spring Boot:");
            for (String beanName : ctx.getBeanDefinitionNames()) {
                // System.out.println(beanName);
            }
        };
    }
}