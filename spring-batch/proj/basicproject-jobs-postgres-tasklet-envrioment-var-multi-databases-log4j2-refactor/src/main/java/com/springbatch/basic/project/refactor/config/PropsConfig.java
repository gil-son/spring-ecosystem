package com.springbatch.basic.project.refactor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class PropsConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer configurer(){

        String path = "./etc/config/printhellojob/application.properties";

        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocation(new FileSystemResource(path));
        return configurer;
    }


}
