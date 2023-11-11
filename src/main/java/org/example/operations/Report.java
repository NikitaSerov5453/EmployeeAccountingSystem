package org.example.operations;

import org.example.campaigns.Campaign;
import org.example.campaigns.Department;
import org.example.campaigns.Employee;
import org.example.views.View;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Report {

    private final View view = new View();
    private Campaign campaign;


    public Report() {

    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public void departments() {
        System.out.println(this.campaign.getDepartments());
    }

    public void listPosts() {
        System.out.println(this.campaign.getPosts());
    }

    public void listEmployees() {
        System.out.println(this.campaign.getEmployee());
    }

    public void averageSalaryCompany() {
        double salary = 0;
        for (int i = 0; i < campaign.getEmployee().size(); i++) {
            salary += campaign.getEmployee().get(i).getSalary();
        }
        System.out.println("Средняя зарплата по кампании: " + salary / campaign.getEmployee().size());
        System.out.println();
    }

    private double calculateAverageSalaryDepartment(Department department) {
        double salary = 0;
        for (int i = 0; i < department.getEmployee().size(); i++) {
            salary += department.getEmployee().get(i).getSalary();
        }
        return salary / department.getEmployee().size();
    }

    public void averageSalaryDepartments() {
        System.out.printf("%25s%25s", "Отдел", "Средняя зарплата\n");
        for (int i = 0; i < campaign.getDepartments().size(); i++) {
            System.out.printf("%25s%25s%25s", campaign.getDepartments().get(i).getDepartmentName(),
                    calculateAverageSalaryDepartment(campaign.getDepartments().get(i)), '\n');
        }
        System.out.println();
    }

    public void topExpensiveEmployee() {
        List<Employee> employees = new ArrayList<>(campaign.getEmployee());
        employees.sort(Comparator.comparing(Employee::getSalary).reversed());
        System.out.printf("%25s%25s", "ФИО сотрдуника", "Зарплата\n");
        for (int i = 0; i < employees.size() && i < 10; i++) {
            System.out.printf("%25s%25s%25s", employees.get(i).getSurname() + ' ' +
                            employees.get(i).getName() + ' ' +
                            employees.get(i).getPatronymic(),
                    employees.get(i).getSalary(), '\n');
        }
        System.out.println();
    }

    public void topDevoteesEmployee() {
        List<Employee> employees = new ArrayList<>(campaign.getEmployee());
        employees.sort(Comparator.comparing(Employee::getDateOfEmployment));
        System.out.printf("%25s%25s", "ФИО", "Дата трудоустройства\n");
        for (int i = 0; i < employees.size() && i < 10; i++) {
            System.out.printf("%25s%25s%25s", employees.get(i).getSurname() + ' ' +
                            employees.get(i).getName() + ' ' +
                            employees.get(i).getPatronymic(),
                    employees.get(i).getDateOfEmployment(), '\n');
        }
        System.out.println();
    }

    public void companyStructure() {
        System.out.format("%25s%25s", "Отдел", "Руководитель\n");
        for (int i = 0; i < campaign.getDepartments().size(); i++) {
            System.out.format("%25s%25s%25s", campaign.getDepartments().get(i).getDepartmentName(),
                    view.printChief(campaign.getDepartments().get(i).getChief()), '\n');
        }
        System.out.println();
    }
}
