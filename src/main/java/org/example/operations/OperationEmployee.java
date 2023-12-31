package org.example.operations;

import org.example.campaigns.*;
import org.example.views.View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class OperationEmployee {
    private final Scanner scanner = new Scanner(System.in);
    private final View view = new View();
    private Employee employee;
    private Campaign campaign;

    public OperationEmployee() {

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

    public void deleteEmployee(int index) {
        campaign.getEmployee().remove(index);
    }

    public void editSurname(String surname) {
        this.employee.setSurname(surname);
    }

    public void editName(String name) {
        this.employee.setName(name);
    }

    public void editPatronymic(String patronymic) {
        this.employee.setPatronymic(patronymic);
    }

    public void editDateOfBirth(String dateOfBirth) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse(dateOfBirth, dateTimeFormatter);
        this.employee.setDateOfBirth(localDate);
    }

    public void editDateOfEmployment(String dateOfEmployment) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse(dateOfEmployment, dateTimeFormatter);
        this.employee.setDateOfEmployment(localDate);
    }

    public void editGender(int i) {
        while (true) {
            switch (i) {
                case 1 -> {
                    this.employee.setGender(Gender.MALE);
                    return;
                }
                case 2 -> {
                    this.employee.setGender(Gender.FEMALE);
                    return;
                }
                case 3 -> {
                    return;
                }
                default -> view.printErrSetNumber();
            }
        }
    }

    public void editTelephoneNumber(String telephoneNumber) {
        this.employee.setTelephoneNumber(telephoneNumber);
    }

    public void editDepartment(Department department) {
        employee.setDepartment(department);
    }

    public void editPost(Post post) {
        employee.setPost(post);
    }

    public void createEmployee(String surname, String name, String patronymic, LocalDate dateOfBirth) {
        Employee employee = new Employee(surname, name, patronymic, dateOfBirth);
        employee.setDateOfEmployment(LocalDate.now());
        campaign.addEmployee(employee);
    }

    public void editSalary(int salary) {
        this.employee.setSalary(salary);
    }

    public void cleanDepartmentAndPost() {
        employee.setPost(null);
        employee.setDepartment(null);
    }


    public Employee takeEmployee(HashSet<Employee> employees) {
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

    public void deletePostFromEmployee(List<Employee> employees, int postID) {
        for (Employee employee : employees) {
            if (postID == employee.getPost().getPostID()) {
                employee.setPost(null);
            }
        }
    }

    public int searchIndexEmployee(List<Employee> employees, int ID) {
        for (int i = 0; i < employees.size(); i++) {
            if (ID == employees.get(i).getEmployeeID()) {
                return i;
            }
        }

        return -1;
    }
}
