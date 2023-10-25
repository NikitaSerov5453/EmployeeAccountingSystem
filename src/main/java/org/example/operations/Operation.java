package org.example.operations;

import org.example.campaign.Department;
import org.example.humans.Employee;

public class Operation {

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

}
