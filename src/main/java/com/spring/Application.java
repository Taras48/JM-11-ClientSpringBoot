package com.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder
                .basicAuthorization("admin", "qwe").build();
        return restTemplate;
    }

    /*@Bean
    @Autowired
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {

        RestTemplate restTemplate = builder
                .basicAuthorization("admin", "$2a$10$ziJKCTIBnsu6SELx0WsFmuiDkSiqHEz.AoVckNEHIE9Kq6Jdkvjj.").build();
        return restTemplate;

        *//*RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("user", "password"));
        return restTemplate;

        return builder.basicAuthorization("name", "password").build();
        return new RestTemplate();*//*
    }*/
}
