package org.example.campaigns;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Campaign implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final List<Department> departments = new ArrayList<>();
    private final List<Employee> employees = new ArrayList<>();
    private final List<Post> posts = new ArrayList<>();

    private String campaignName;


    public Campaign(String campaignName) {
        this.campaignName = campaignName;
    }


    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "campaignName='" + campaignName + '\'' +
                '}';
    }




    public void addDepartments(Department department) {
        this.departments.add(department);
    }

    public void deleteDepartment(int index) {
        this.departments.remove(index);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public List<Employee> getEmployee() {
        return employees;
    }

    public void addPosts(Post posts) {
        this.posts.add(posts);
    }

    public List<Post> getPosts() {
        return posts;
    }
}
