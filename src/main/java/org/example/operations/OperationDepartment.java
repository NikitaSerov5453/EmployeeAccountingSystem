package org.example.operations;

import org.example.campaigns.Campaign;
import org.example.campaigns.Department;

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

    public void deleteDepartment(int index) {
        campaign.getDepartments().remove(index);
    }

    public void editDepartmentName(String name) {
        this.department.setDepartmentName(name);
    }

    public void editDepartmentChief(int newChiefEmployeeID) {
        this.department.setChief(department.getEmployee().get(newChiefEmployeeID));
    }
}
