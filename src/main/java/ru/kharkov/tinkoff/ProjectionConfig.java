package ru.kharkov.tinkoff;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

@Configuration
public class ProjectionConfig {

    @Bean
    public ProjectionFactory getProjectionFactory(){
        return new SpelAwareProxyProjectionFactory();
    }
}
