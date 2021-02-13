package ru.mirea.builder;

public class ProjectManager {
    private final TeamBuilder teamBuilder;

    public ProjectManager(TeamBuilder teamBuilder) {
        this.teamBuilder = teamBuilder;
    }

    public Team setTeam() {
        teamBuilder.createTeam();
        teamBuilder.buildName();
        teamBuilder.buildMembersNum();
        return teamBuilder.getTeam();
    }
}
