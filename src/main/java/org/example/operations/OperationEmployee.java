package org.example.operations;

import org.example.campaigns.Campaign;
import org.example.campaigns.Employee;

import java.util.Scanner;

public class OperationEmployee {
    private final Scanner scanner = new Scanner(System.in);
    private Campaign campaign;

    public OperationEmployee() {

    }

    private void createEmployee(String surname, String name, String patronymic) {
        campaign.data.addEmployee(new Employee(surname, name, patronymic));
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


    public void createEmployeeMenu() {
        System.out.println("Введите фамилию сотрдуника:");
        String surname = scanner.next();
        System.out.println("Введите имя сотрудника:");
        String name = scanner.next();
        System.out.println("Введите отчество сотрдуника:");
        String patronymic = scanner.next();
        createEmployee(surname, name, patronymic);
    }
}
