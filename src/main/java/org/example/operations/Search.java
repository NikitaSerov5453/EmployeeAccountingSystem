package org.example.operations;

import org.example.campaigns.Department;

import java.util.List;

public class Search {

    public Search() {

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
