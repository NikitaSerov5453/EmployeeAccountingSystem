package org.example.operations;

import org.example.campaigns.Department;
import org.example.campaigns.Post;
import org.example.campaigns.Campaign;
import org.example.files.File;
import org.example.files.Serialized;
import org.example.humans.Employee;

import java.util.Scanner;

public class Operation {
    private final Scanner scanner = new Scanner(System.in);

    public Operation() {

    }

    public Employee createEmployee(String surname, String name, String patronymic) {
        return new Employee(surname, name, patronymic);
    }

    public void deleteEmployee() {

    }

    public void editEmployee() {

    }

    public Department createDepartment(String nameDepartment) {
        return new Department(nameDepartment);
    }

    public Post createPost(String namePost) {
        return new Post(namePost);
    }

    public void createCompany() {
        System.out.println("Введите название кампании:");
        String campaignName = scanner.nextLine();
        Campaign campaign = new Campaign(campaignName);
        Serialized.serialized(campaign, campaignName + campaign.hashCode());
        System.out.println("Ваша кампания: " + campaignName + " создана\n");
    }

    public void loadCampaign(String file) {
        Serialized.deserialized(file);
    }

}
