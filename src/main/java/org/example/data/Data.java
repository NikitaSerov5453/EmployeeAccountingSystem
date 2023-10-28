package org.example.data;

import org.example.campaigns.Department;
import org.example.campaigns.Post;
import org.example.humans.Employee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Data implements Serializable {

    private final List<Department> departments = new ArrayList<>();
    private final List<Employee> employees = new ArrayList<>();
    private final List<Post> posts = new ArrayList<>();

    public Data() {

    }

    public void addDepartments(Department department) {
        this.departments.add(department);
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
