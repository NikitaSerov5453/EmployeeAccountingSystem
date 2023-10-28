package org.example;

import org.example.campaigns.Department;
import org.example.campaigns.Campaign;
import org.example.files.Serialized;
import org.example.humans.Employee;
import org.example.operations.Menu;

public class Main {
    public static void main(String[] args) {
//        Menu menu = new Menu();
//        menu.start();
        Employee employee = new Employee("Serov","Nikita","Andreevic");
        Employee employee1 = new Employee("1", "1", "1");
        Employee employee2 = new Employee("2", "2", "2");
//        System.out.println(employee);
//        System.out.println(employee1);
//        System.out.println(employee2);
        Department department = new Department("Начальство");
        Campaign campaign = new Campaign("Camp");
        campaign.data.addDepartments((department));
        Campaign campaign1;
        Serialized.serialized(campaign, "Campaign");
        campaign1 = (Campaign) Serialized.deserialized("Campaign");
//        System.out.println(campaign1);
//        System.out.println(campaign1.getDepartments());
        System.out.println(campaign1.data.getDepartments().get(0).getChief());
    }
}