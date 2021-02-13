package ru.mirea.builder;

public class AnalyticsTeam extends TeamBuilder {
    @Override
    protected void buildName() {
        team.setName("Analytics");
    }

    @Override
    protected void buildMembersNum() {
        team.setMembersNum(3);
    }
}
