package ru.mirea.factory;

import java.util.function.Supplier;

public interface AgileFramework {
    void startDevelopment();

    enum AgileType {
        SCRUM(Scrum::new),
        KANBAN(Kanban::new);

        private final Supplier<AgileFramework> framework;

        AgileType(Supplier<AgileFramework> framework) {
            this.framework = framework;
        }

        public Supplier<AgileFramework> getFramework() {
            return framework;
        }
    }
}
