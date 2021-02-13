package ru.mirea.builder;

abstract public class TeamBuilder {
    protected Team team;

    protected void createTeam() {
        team = new Team();
    }

    protected Team getTeam() {
        return team;
    }

    protected abstract void buildName();

    protected abstract void buildMembersNum();
}
