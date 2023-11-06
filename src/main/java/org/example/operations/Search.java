package org.example.operations;

import org.example.campaigns.Campaign;
import org.example.campaigns.Department;
import org.example.campaigns.Employee;

import java.io.Serializable;
import java.util.HashSet;
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

    public HashSet<Employee> searchEmployeeFCs(String string) {
        HashSet<Employee> employees = new HashSet<>();
        string = string.toLowerCase();
        for (int i = 0; i < campaign.data.getEmployee().size(); i++) {
            if (campaign.data.getEmployee().get(i).getName().toLowerCase().contains(string)
                    || campaign.data.getEmployee().get(i).getSurname().toLowerCase().contains(string)
                    || campaign.data.getEmployee().get(i).getPatronymic().toLowerCase().contains(string)) {
                employees.add(campaign.data.getEmployee().get(i));
            }
        }
        return employees;
    }


    public HashSet<Employee> searchEmployeePost(String postName) {
        HashSet<Employee> employees = new HashSet<>();
        postName = postName.toLowerCase();
        for (int i = 0; i < campaign.data.getPosts().size(); i++) {
            if (campaign.data.getEmployee().get(i).getPost().getPostName().toLowerCase().contains(postName)) {
                employees.add(campaign.data.getEmployee().get(i));
            }
        }
        return employees;
    }

    public HashSet<Employee> searchEmployeeDepartment(String departmentName) {
        HashSet<Employee> employees = new HashSet<>();
        departmentName = departmentName.toLowerCase();
        for (int i = 0; i < campaign.data.getEmployee().size(); i++) {
            if (campaign.data.getEmployee().get(i).getDepartment().getDepartmentName().toLowerCase().contains(departmentName)) {
                employees.add(campaign.data.getEmployee().get(i));
            }
        }
        return employees;
    }

    public HashSet<Employee> searchEmployeeChief(String FCs) {
        HashSet<Employee> employees = new HashSet<>();
        FCs = FCs.toLowerCase();
        for (int i = 0; i < campaign.data.getEmployee().size(); i++) {
            if (campaign.data.getEmployee().get(i).getChief().getName().toLowerCase().contains(FCs)
                    || campaign.data.getEmployee().get(i).getChief().getSurname().toLowerCase().contains(FCs)
                    || campaign.data.getEmployee().get(i).getChief().getPatronymic().toLowerCase().contains(FCs)) {
                employees.add(campaign.data.getEmployee().get(i));
            }
        }
        return employees;
    }

    public Employee searchEmployeeID(int employeeID) {
        for (int i = 0; i < campaign.data.getEmployee().size(); i++) {
            if (campaign.data.getEmployee().get(i).getEmployeeID() == employeeID) {
                return campaign.data.getEmployee().get(i);
            }
        }

        return null;
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
