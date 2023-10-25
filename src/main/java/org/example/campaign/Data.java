package org.example.campaign;

import org.example.humans.Employee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Data implements Serializable {

    private static final List<Department> departments = new ArrayList<>();
    private static final List<Employee> employees = new ArrayList<>();
    private static final List<Post> posts = new ArrayList<>();

    public Data() {

    }

    public void setDepartments(Department department) {
        Data.departments.add(department);
    }

    public static List<Department> getDepartments() {
        return departments;
    }

    public void setEmployee(Employee employee) {
        Data.employees.add(employee);
    }

    public static List<Employee> getEmployee() {
        return employees;
    }

    public void setPosts(Post posts) {
        Data.posts.add(posts);
    }

    public static List<Post> getPosts() {
        return posts;
    }
}
