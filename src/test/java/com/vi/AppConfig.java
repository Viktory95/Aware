package com.vi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public UserTest getHibernateTest() {
        return new UserTest();
    }
}
