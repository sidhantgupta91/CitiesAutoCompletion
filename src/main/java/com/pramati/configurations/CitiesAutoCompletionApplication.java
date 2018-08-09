
package com.pramati.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.pramati")
@Configuration
@EnableAutoConfiguration
public class CitiesAutoCompletionApplication extends SpringBootServletInitializer
{

    private static final Logger LOGGER = LoggerFactory.getLogger(CitiesAutoCompletionApplication.class);
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(CitiesAutoCompletionApplication.class);
    }

    public static void main(String[] args)
    {
        SpringApplication.run(CitiesAutoCompletionApplication.class, args);
    }

}
