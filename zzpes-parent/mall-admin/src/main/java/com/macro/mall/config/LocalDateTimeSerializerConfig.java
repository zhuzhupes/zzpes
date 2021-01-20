package com.macro.mall.config;


import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalDateTimeSerializerConfig {

//    @Value("${spring.jackson.date-format:yyyy-MM-dd HH:mm:ss}")
//    private String pattern;
//
//    @Bean
//    public LocalDateTimeSerializer localDateTimeSerializer(){
//        return new LocalDateTimeSerializer(DateTimeFormater.ofPattern(pattern));
//    }
//
//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer(){
//        return builder -> builder.serializerByType(LocalDateTime.class, localDateTimeSerializer());
//    }
}
