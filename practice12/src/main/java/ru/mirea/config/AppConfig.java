package ru.mirea.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Configuration via annotations
 */
@Configuration
@ComponentScan({"ru.mirea.models", "ru.mirea.services"})
@PropertySource("classpath:application.properties")
public class AppConfig {
}
