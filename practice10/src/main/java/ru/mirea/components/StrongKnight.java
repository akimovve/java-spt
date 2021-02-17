package ru.mirea.components;

import org.springframework.stereotype.Component;
import ru.mirea.interfaces.Knight;

@Component
public class StrongKnight implements Knight {
    @Override
    public void fight() {
        System.out.println("Strong Knight is fighting...");
    }
}
