package org.example.campaigns;

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


    private List<Employee> employee = new ArrayList<>();

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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.chief);
        out.writeObject(numberCreation);
        out.writeObject(this.departmentName);
        out.writeObject(this.employee);
        out.writeObject(this.departmentID);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.chief = (Employee) in.readObject();
        numberCreation = (int) in.readObject();
        this.departmentName = (String) in.readObject();
        this.employee = Collections.unmodifiableList(this.employee); in.readObject();
        this.departmentID = (int) in.readObject();
    }
}
