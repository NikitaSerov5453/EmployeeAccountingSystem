package org.example.operations;

import org.example.campaigns.Campaign;
import org.example.campaigns.Department;

import java.io.Serializable;
import java.util.List;

public class Search implements Serializable {

    private Campaign campaign;

    public Search() {

    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public void searchEmployeeFCs() {

    }

    public void searchEmployeePost() {

    }

    public void searchEmployeeDepartment() {

    }

    public void searchEmployeeChief() {

    }

    public int searchIndexDepartment(List<Department> departments, int ID) {
        int index = 0;
        for (int i = 0; i < departments.size(); i++) {
            if (ID == departments.get(i).getDepartmentID()) {
                index = i;
                break;
            }
        }
        return index;
    }
}
