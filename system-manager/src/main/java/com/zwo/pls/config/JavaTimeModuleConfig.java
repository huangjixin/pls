package com.zwo.pls.config;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.YearMonthDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.YearMonthSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

/**
 * [描述] jackson.jsr310.JavaTimeModule配置
 *
 * @author Yuanquan.Liu
 * @date 2019/6/11
 */
@Configuration
public class JavaTimeModuleConfig {
    @Bean(name = "javaTimeModule")
    public JavaTimeModule javaTimeModule() {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        // 序列化配置
        javaTimeModule.addSerializer(YearMonth.class, yearMonthSerializer());
        javaTimeModule.addSerializer(LocalDateTime.class, localDateTimeSerializer());
        javaTimeModule.addSerializer(LocalDate.class, localDateSerializer());
        javaTimeModule.addSerializer(LocalTime.class, localTimeSerializer());
        // 反序列化配置
        javaTimeModule.addDeserializer(YearMonth.class, yearMonthDeserializer());
        javaTimeModule.addDeserializer(LocalDateTime.class, localDateTimeDeserializer());
        javaTimeModule.addDeserializer(LocalDate.class, localDateDeserializer());
        javaTimeModule.addDeserializer(LocalTime.class, localTimeDeserializer());
        return javaTimeModule;
    }

    @Bean
    public YearMonthSerializer yearMonthSerializer() {
        return new YearMonthSerializer(DateTimeFormatter.ofPattern("yyyy-MM"));
    }

    @Bean
    public LocalDateTimeSerializer localDateTimeSerializer() {
        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Bean
    public LocalDateSerializer localDateSerializer() {
        return new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Bean
    public LocalTimeSerializer localTimeSerializer() {
        return new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    @Bean
    public YearMonthDeserializer yearMonthDeserializer() {
        return new YearMonthDeserializer(DateTimeFormatter.ofPattern("yyyy-MM"));
    }

    @Bean
    public LocalDateTimeDeserializer localDateTimeDeserializer() {
        return new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Bean
    public LocalDateDeserializer localDateDeserializer() {
        return new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Bean
    public LocalTimeDeserializer localTimeDeserializer() {
        return new LocalTimeDeserializer(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
