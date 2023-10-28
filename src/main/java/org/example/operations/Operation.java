package org.example.operations;

import org.example.campaigns.Department;
import org.example.campaigns.Post;
import org.example.campaigns.Campaign;
import org.example.files.File;
import org.example.humans.Employee;

public class Operation {

    File file = new File();

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

    public Campaign createCompany(String companyName) {
        Campaign campaign = new Campaign(companyName);
        file.setCampaign(campaign);
        return campaign;
    }

}
