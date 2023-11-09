package org.example.operations;

import org.example.campaigns.Campaign;
import org.example.campaigns.Department;
import org.example.campaigns.Employee;
import org.example.campaigns.Post;

import java.util.HashSet;
import java.util.List;

public class Search {

    private Campaign campaign;

    public Search() {

    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public HashSet<Employee> searchEmployeeFCs(String string) {
        HashSet<Employee> employees = new HashSet<>();
        string = string.toLowerCase();
        for (int i = 0; i < campaign.getEmployee().size(); i++) {
            if (campaign.getEmployee().get(i).getName().toLowerCase().contains(string)
                    || campaign.getEmployee().get(i).getSurname().toLowerCase().contains(string)
                    || campaign.getEmployee().get(i).getPatronymic().toLowerCase().contains(string)) {
                employees.add(campaign.getEmployee().get(i));
            }
        }
        return employees;
    }


    public HashSet<Employee> searchEmployeePost(String postName) {
        HashSet<Employee> employees = new HashSet<>();
        postName = postName.toLowerCase();
        for (int i = 0; i < campaign.getPosts().size(); i++) {
            if (campaign.getEmployee().get(i).getPost().getPostName().toLowerCase().contains(postName)) {
                employees.add(campaign.getEmployee().get(i));
            }
        }
        return employees;
    }

    public HashSet<Employee> searchEmployeeDepartment(String departmentName) {
        HashSet<Employee> employees = new HashSet<>();
        departmentName = departmentName.toLowerCase();
        for (int i = 0; i < campaign.getEmployee().size(); i++) {
            if (campaign.getEmployee().get(i).getDepartment().getDepartmentName().toLowerCase().contains(departmentName)) {
                employees.add(campaign.getEmployee().get(i));
            }
        }
        return employees;
    }

    public HashSet<Employee> searchEmployeeChief(String FCs) {
        HashSet<Employee> employees = new HashSet<>();
        FCs = FCs.toLowerCase();
        for (int i = 0; i < campaign.getEmployee().size(); i++) {
            if (campaign.getEmployee().get(i).getChief().getName().toLowerCase().contains(FCs)
                    || campaign.getEmployee().get(i).getChief().getSurname().toLowerCase().contains(FCs)
                    || campaign.getEmployee().get(i).getChief().getPatronymic().toLowerCase().contains(FCs)) {
                employees.add(campaign.getEmployee().get(i));
            }
        }
        return employees;
    }

    public Employee searchEmployeeID(int employeeID) {
        for (int i = 0; i < campaign.getEmployee().size(); i++) {
            if (campaign.getEmployee().get(i).getEmployeeID() == employeeID) {
                return campaign.getEmployee().get(i);
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

    public int searchIndexPost(List<Post> posts, int ID) {
        int index = 0;
        for (int i = 0; i < posts.size(); i++) {
            if (ID == posts.get(i).getPostID()) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int searchIndexEmployee(List<Employee> employees, int ID) {
        int index = 0;
        for (int i = 0; i < employees.size(); i++) {
            if (ID == employees.get(i).getEmployeeID()) {
                index = i;
                break;
            }
        }
        return index;
    }
}
