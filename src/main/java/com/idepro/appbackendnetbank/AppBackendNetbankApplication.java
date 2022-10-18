package com.idepro.appbackendnetbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AppBackendNetbankApplication extends SpringBootServletInitializer {
//public class AppBackendNetbankApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppBackendNetbankApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppBackendNetbankApplication.class);
    }

}
