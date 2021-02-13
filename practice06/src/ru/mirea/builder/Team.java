package ru.mirea.builder;

public class Team {
    private String name;
    private int members;

    public void setName(String name) {
        this.name = name;
    }

    public void setMembersNum(int members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", members=" + members +
                '}';
    }
}
