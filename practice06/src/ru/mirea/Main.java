package ru.mirea;

import ru.mirea.abstractFactory.AgileTeamFactory;
import ru.mirea.abstractFactory.ProductManager;
import ru.mirea.abstractFactory.SoftwareDeveloper;
import ru.mirea.abstractFactory.enterprise.EnterpriseTeam;
import ru.mirea.builder.AnalyticsTeam;
import ru.mirea.builder.ProjectManager;
import ru.mirea.factory.AgileFramework;
import ru.mirea.factory.AgileFrameworkFactory;
import ru.mirea.prototype.Branch;

public class Main {

    public static void main(String[] args) {
        System.out.println("Тест. метода 'фабрика'");
        AgileFramework scrum =
                AgileFrameworkFactory.getAgileFramework(AgileFramework.AgileType.SCRUM);
        AgileFramework kanban =
                AgileFrameworkFactory.getAgileFramework(AgileFramework.AgileType.KANBAN);
        scrum.startDevelopment();
        kanban.startDevelopment();

        System.out.println("\nТест. метода 'абстрактная фабрика'");
        AgileTeamFactory agileTeam = new EnterpriseTeam();
        ProductManager pm = agileTeam.getProductManager();
        SoftwareDeveloper sd = agileTeam.getSoftwareDeveloper();
        pm.manage();
        sd.develop();

        System.out.println("\nТест. метода 'строитель'");
        ProjectManager projectManager = new ProjectManager(new AnalyticsTeam());
        System.out.println(projectManager.setTeam());

        System.out.println("\nТест. метода 'прототип'");
        Branch branch1 = new Branch("master", 247);
        System.out.println("Source: " + branch1);
        Branch branch2 = (Branch) branch1.prototype();
        System.out.println("Copy: " + branch2);
    }
}
