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

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void createDepartment(String nameDepartment) {
        Department department = new Department(nameDepartment);
        campaign.data.addDepartments(department);
    }

    public void deleteDepartment() {
        campaign.data.deleteDepartment(this.department.getDepartmentID() - 1);
    }

    public void editDepartmentName(String name) {
        this.department.setDepartmentName(name);
    }

    public void editDepartmentChief(int newChiefEmployeeID) {
        this.department.setChief(department.getEmployee().get(newChiefEmployeeID));
    }

}
