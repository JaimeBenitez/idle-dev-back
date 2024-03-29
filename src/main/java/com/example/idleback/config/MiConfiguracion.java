package com.example.idleback.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MiConfiguracion {

    @Bean
    public ModelMapper modelMapper(){ return new ModelMapper();}

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
        @Override
            public void addCorsMappings(CorsRegistry registry){
                    registry.addMapping("/**")
                            .allowedOrigins("http://localhost:8080","http://localhost:8081","https://idle-dev.netlify.app")
                    .allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                            .allowCredentials(true);
        }
        };
    }


}
