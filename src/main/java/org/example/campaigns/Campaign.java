package org.example.campaigns;

import org.example.operations.OperationDepartment;
import org.example.operations.OperationEmployee;
import org.example.operations.OperationPost;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Campaign implements Externalizable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int campaignID;
    private static int numberCreation;
    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();

    private String campaignName;


    public Campaign(String campaignName) {
        numberCreation++;
        this.campaignID = numberCreation;
        this.campaignName = campaignName;
    }

    public Campaign() {
    }

    public int getCampaignID() {
        return campaignID;
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

    public void deletePost(int index) {
        this.posts.remove(index);
    }

    public List<Post> getPosts() {
        return posts;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.departments);
        out.writeObject(this.employees);
        out.writeObject(this.posts);
        out.writeObject(this.campaignName);
        out.writeObject(this.campaignID);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.departments = (List<Department>) in.readObject();
        this.employees = (List<Employee>) in.readObject();
        this.posts = (List<Post>) in.readObject();
        this.campaignName = (String) in.readObject();
        this.campaignID = (int) in.readObject();
    }
}
