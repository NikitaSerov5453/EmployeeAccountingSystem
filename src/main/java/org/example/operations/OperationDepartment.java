package org.example.operations;

import org.example.campaigns.Campaign;
import org.example.campaigns.Department;
import org.example.campaigns.Employee;

public class OperationDepartment {
    private Department department;
    private Campaign campaign;

    public OperationDepartment() {

    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public void createDepartment(String nameDepartment) {
        Department department = new Department(nameDepartment);
        campaign.addDepartments(department);
    }

    public void deleteDepartment(int index) {
        campaign.getDepartments().remove(index);
    }

    public void editDepartmentName(String name) {
        this.department.setDepartmentName(name);
    }

    public void editDepartmentChief(Employee employee) {
        this.department.setChief(employee);
    }
}
