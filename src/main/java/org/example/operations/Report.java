package org.example.operations;

import org.example.campaigns.Campaign;
import org.example.campaigns.Department;
import org.example.campaigns.Employee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Report implements Serializable {

    private Campaign campaign;

    public Report() {

    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public void departments() {
        System.out.println(this.campaign.data.getDepartments());
    }

    public void listPosts() {
        System.out.println(this.campaign.data.getPosts());
    }

    public void listEmployees() {
        System.out.println(this.campaign.data.getEmployee());
    }

    public void averageSalaryCompany() {
        double salary = 0;
        for (int i = 0; i < campaign.data.getEmployee().size(); i++) {
            salary += campaign.data.getEmployee().get(i).getSalary();
        }
        System.out.println("Средняя зарплата по кампании: " + salary);
    }

    private double calculateAverageSalaryDepartment(Department department) {
        double salary = 0;
        for (int i = 0; i < department.getEmployee().size(); i++) {
            salary += department.getEmployee().get(i).getSalary();
        }
        return salary;
    }

    public void averageSalaryDepartments() {
        String pattern = "%25s%25s";
        System.out.printf(pattern, "Отдел", "Средняя зарплата\n");
        for (int i = 0; i < campaign.data.getDepartments().size(); i++) {
            System.out.printf(pattern, campaign.data.getDepartments().get(i).getDepartmentName(),
                    calculateAverageSalaryDepartment(campaign.data.getDepartments().get(i)));
        }
    }

    public void topExpensiveEmployee() {
        List<Employee> employees = new ArrayList<>(campaign.data.getEmployee());
        employees.sort(Comparator.comparing(Employee::getSalary).reversed());
        System.out.printf("%25s%25s", "ФИО сотрдуника", "Зарплата\n");
        for (int i = 0; i < employees.size() && i < 11; i++) {
            System.out.printf("%25s%25s%25s", employees.get(i).getSurname() + ' ' +
                    employees.get(i).getName() + ' ' +
                    employees.get(i).getPatronymic(),
                    employees.get(i).getSalary(), '\n');
        }
    }

    public void topDevoteesEmployee() {
        List<Employee> employees = new ArrayList<>(campaign.data.getEmployee());
        employees.sort(Comparator.comparing(Employee::getDateOfEmployment).reversed());
        System.out.printf("%25s%25s", "ФИО", "Дата трудоустройства\n");
        for (int i = 0; i < employees.size() && i < 11; i++) {
            System.out.printf("%25s%25s%25s", employees.get(i).getSurname() + ' ' +
                    employees.get(i).getName() + ' ' +
                    employees.get(i).getPatronymic(),
                    employees.get(i).getDateOfEmployment(), '\n');
        }
    }

    public void companyStructure() {
        String pattern = "%25s%25s";
        System.out.format(pattern, "Отдел", "Руководитель\n");
        for (int i = 0; i < campaign.data.getDepartments().size(); i++) {
            System.out.format(pattern, campaign.data.getDepartments().get(i).getDepartmentName(),
                    campaign.data.getDepartments().get(i).getChief());
        }
    }
}
