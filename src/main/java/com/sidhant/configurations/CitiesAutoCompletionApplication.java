
package com.sidhant.configurations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.sidhant")
@Configuration
@EnableAutoConfiguration
public class CitiesAutoCompletionApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CitiesAutoCompletionApplication.class);
    }

    public static void main(String[] args){
        SpringApplication.run(CitiesAutoCompletionApplication.class, args);
    }

}
