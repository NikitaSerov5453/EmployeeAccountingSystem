package org.example.operations;

import org.example.campaigns.Campaign;
import org.example.campaigns.Department;

import java.util.Scanner;

public class OperationDepartment {
    private final Scanner scanner = new Scanner(System.in);
    private Campaign campaign;
    private Department department;


    public OperationDepartment() {

    }

    private void createDepartment(String nameDepartment) {
        campaign.data.addDepartments(new Department(nameDepartment));
    }

    public void deleteDepartment() {
        campaign.data.deleteDepartment(this.department.getDepartmentID() - 1);
    }

    public void editDepartment() {

    }

    public void editDepartmentName(String name) {
        this.department.setDepartmentName(name);
    }

    public void editDepartmentChief() {

    }

    public void createDepartmentMenu() {
        System.out.println("Введите название отдела");
        scanner.nextLine();
        String departmentName = scanner.nextLine();
        createDepartment(departmentName);
        System.out.println("Отдел: " + departmentName + " создан\n");

    }
}
