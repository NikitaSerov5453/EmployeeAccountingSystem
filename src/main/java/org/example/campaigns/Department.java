package org.example.campaigns;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Department implements Serializable {

    private final int departmentID;
    private static int numberCreation;
    private String departmentName;
    private Employee chief;


    private final List<Employee> employee = new ArrayList<>();

    public Department(String departmentName) {
        numberCreation++;
        this.departmentName = departmentName;
        this.departmentID = numberCreation;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setEmployee(Employee employee) {
        this.employee.add(employee);
    }

    public List<Employee> getEmployee() {
        return employee;
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

    @Override
    public String toString() {
        return "\nНомер отдела: " + departmentID +
                " Отдел: " + departmentName +
                " Руководитель: " + chief;

    }
}
