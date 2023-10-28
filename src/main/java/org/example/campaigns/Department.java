package org.example.campaigns;

import org.example.humans.Employee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Department implements Serializable {

    private final String departmentName;

    private Employee chief;
    private final int departmentID;
    private static int numberCreation;

    private final List<Employee> employee = new ArrayList<>();

    public Department(String departmentName) {
        numberCreation++;
        this.departmentName = departmentName;
        this.departmentID = numberCreation;
    }

    public int getNumberCreation() {
        return numberCreation;
    }

    public void setEmployee(Employee employee) {
        this.employee.add(employee);
    }

    public Employee getChief() {
        return chief;
    }

    public void setChief(Employee chief) {
        this.chief = chief;
    }

    @Override
    public String toString() {
        return "\nОтдел: " + departmentName +
                "\nРуководитель: " + chief +
                "\nНомер отдела: " + departmentID + '\n';
    }
}
