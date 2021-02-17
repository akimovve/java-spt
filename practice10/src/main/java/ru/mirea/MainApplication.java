package ru.mirea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mirea.components.KingOfKnights;
import ru.mirea.components.StrongKnight;
import ru.mirea.components.WeakKnight;
import ru.mirea.interfaces.Knight;
import ru.mirea.config.AppConfig;
import ru.mirea.config.BeanConfig;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        /*
        Для конфигурации с помощью java-кода необходимо убрать
        аннотации Component, добавить аннотацию Configuration
        для BeanConfig и раскомментировать данную строчку
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BeanConfig.class);
        */
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Knight k1 = context.getBean(KingOfKnights.class);
        Knight k2 = context.getBean(StrongKnight.class);
        Knight k3 = context.getBean(WeakKnight.class);
        k1.fight();
        k2.fight();
        k3.fight();
    }
}
