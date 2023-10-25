package org.example.campaign;

import org.example.humans.Employee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Department implements Serializable {

    private String departmentName;
    private int departmentID;
    private final int numberCreation;

    private static final List<Employee> employee = new ArrayList<>();

    public Department(String departmentName) {
        departmentID++;
        this.departmentName = departmentName;
        this.numberCreation = departmentID;
    }

    public int getNumberCreation() {
        return numberCreation;
    }

    public void setEmployee(Employee employee) {
        Department.employee.add(employee);
    }

}
