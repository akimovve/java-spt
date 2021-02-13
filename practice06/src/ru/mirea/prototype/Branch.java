package ru.mirea.prototype;

public class Branch implements Prototypable {
    private final String name;
    private final int commits;

    public Branch(String name, int commits) {
        this.name = name;
        this.commits = commits;
    }

    @Override
    public Object prototype() {
        return new Branch(name, commits);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "name='" + name + '\'' +
                ", commits=" + commits +
                '}';
    }
}
