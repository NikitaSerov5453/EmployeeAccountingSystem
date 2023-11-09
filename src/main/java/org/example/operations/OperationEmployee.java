package org.example.operations;

import org.example.campaigns.Campaign;
import org.example.campaigns.Employee;
import org.example.campaigns.Post;
import org.example.views.View;

import java.util.HashSet;
import java.util.Scanner;

public class OperationEmployee {
    private final Scanner scanner = new Scanner(System.in);
    private View view = new View();
    private Employee employee;
    private Campaign campaign;

    public OperationEmployee() {

    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void createEmployee(String surname, String name, String patronymic) {
        Employee employee = new Employee(surname, name, patronymic);
        campaign.addEmployee(employee);
    }

    public void deleteEmployee() {

    }

    public void editEmployee() {

    }

    public void editSurname() {

    }

    public void editName() {

    }

    public void editPatronymic() {

    }

    public void editDateOfBirth() {

    }

    public void editGender() {

    }

    public void editTelephoneNumber() {

    }

    public void editDepartment() {

    }

    public void editPost() {

    }

    public void editChief() {

    }

    public void editSalary() {

    }


    public Employee takeEmployee(HashSet<Employee> employees) {
        System.out.println("Выберете нужного сотрдуника:");
        view.printHashSet(employees);
        int id = scanner.nextInt();
        int counter = 1;
        for (Employee employee : employees) {
            if (counter == id) {
                return employee;
            } else {
                counter++;
            }
        }
        return null;
    }
}
