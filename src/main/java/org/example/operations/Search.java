package org.example.operations;

import org.example.campaigns.Campaign;
import org.example.campaigns.Department;
import org.example.campaigns.Employee;
import org.example.campaigns.Post;

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
        String[] strings = string.split(" ");
        HashSet<Employee> employees = new HashSet<>();
        for (int i = 0; i < campaign.data.getEmployee().size(); i++) {
            for (String s : strings) {
                if (s.equals(campaign.data.getEmployee().get(i).getName())
                        || s.equals(campaign.data.getEmployee().get(i).getSurname())
                        || s.equals(campaign.data.getEmployee().get(i).getPatronymic())) {
                    employees.add(campaign.data.getEmployee().get(i));
                }
            }
        }
        return employees;
    }



    public void searchEmployeePost(String postName) {
        String[] strings = postName.split(" ");
        HashSet<Post> posts = new HashSet<>();
        for (int i = 0; i < campaign.data.getPosts().size(); i++) {
            for (int j = 0; j <strings.length; j++) {

            }
        }
    }

    public void searchEmployeeDepartment() {

    }

    public void searchEmployeeChief() {

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
