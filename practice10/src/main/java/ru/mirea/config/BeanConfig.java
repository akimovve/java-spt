package ru.mirea.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mirea.components.KingOfKnights;
import ru.mirea.components.StrongKnight;
import ru.mirea.components.WeakKnight;

// @Configuration
public class BeanConfig {
    @Bean
    public KingOfKnights kingOfKnights() {
        return new KingOfKnights();
    }

    @Bean
    public StrongKnight strongKnight() {
        return new StrongKnight();
    }

    @Bean
    public WeakKnight weakKnight() {
        return new WeakKnight();
    }
}
