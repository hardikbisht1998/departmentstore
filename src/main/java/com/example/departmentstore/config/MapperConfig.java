package com.example.departmentstore.config;


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper getModelMapper(){
        ModelMapper model= new ModelMapper();
        model.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return model;
    }
}
