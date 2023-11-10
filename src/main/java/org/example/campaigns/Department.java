package org.example.campaigns;

import org.example.views.View;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department implements Externalizable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int departmentID;
    private static int numberCreation;
    private String departmentName;
    private Employee chief;
    private final View view = new View();


    private List<Employee> employee = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();

    public Department(String departmentName) {
        numberCreation++;
        this.departmentName = departmentName;
        this.departmentID = numberCreation;
    }

    public Department() {

    }

    public int getDepartmentID() {
        return departmentID;
    }

    public Employee getChief() {
        return chief;
    }

    public void setChief(Employee chief) {
        this.chief = chief;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void addEmployee(Employee employee) {
        this.employee.add(employee);
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void addPosts(Post posts) {
        this.posts.add(posts);
    }

    public List<Post> getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return "\nНомер отдела: " + departmentID +
                " Отдел: " + departmentName +
                " Руководитель: " + view.printChief(chief);

    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.chief);
        out.writeObject(numberCreation);
        out.writeObject(this.departmentName);
        out.writeObject(this.employee);
        out.writeObject(this.departmentID);
        out.writeObject(this.posts);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.chief = (Employee) in.readObject();
        numberCreation = (int) in.readObject();
        this.departmentName = (String) in.readObject();
        this.employee = (List<Employee>) in.readObject();
        this.departmentID = (int) in.readObject();
        this.posts = (List<Post>) in.readObject();
    }
}
