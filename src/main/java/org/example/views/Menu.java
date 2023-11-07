package org.example.views;

import org.example.campaigns.Campaign;
import org.example.campaigns.Employee;
import org.example.operations.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Menu implements Serializable {

    private final Scanner scanner = new Scanner(System.in);
    private Operation operation = new Operation();
    private View view = new View();
    private Campaign campaign;

    public Menu() {

    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }


    public void start() {
        controlCompanyMenu();
    }

    private void def() {
        System.out.println("Неверно введен номер");
    }

    public void controlCompanyMenu() {
        while (true) {
            view.printControlCompanyMenu();
            switch (scanner.nextInt()) {
                case 1 -> {
                    this.campaign = operation.createCompany();
                    mainMenu();
                }
                case 2 -> operation.editCampaign();
                case 3 -> operation.loadCampaign("1521645586");
                default -> def();
            }
        }
    }



    public void editEmployeeMenu() {
        boolean a = true;
        while (a) {
            view.printEditEmployeeMenu();
            switch (scanner.nextInt()) {
                case 1 -> editFCsMenu();
                case 2 -> operation.editDateOfBirth();
                case 3 -> operation.editGender();
                case 4 -> operation.editTelephoneNumber();
                case 5 -> operation.editDepartment();
                case 6 -> operation.editPost();
                case 7 -> operation.editChief();
                case 8 -> operation.editSalary();
                case 9 -> {
                    operation.deleteEmployee();
                    employeeMenu();
                }
                case 0 -> a = false;

                default -> def();
            }
        }
    }

    private void editFCsMenu() {
        boolean a = true;
        while (a) {
            view.printEditFCsMenu();
            switch (scanner.nextInt()) {
                case 1 -> operation.editSurname();
                case 2 -> operation.editName();
                case 3 -> operation.editPatronymic();
                case 4 -> a = false;

                default -> def();
            }
        }
    }

    private void mainMenu() {
        boolean a = true;
        while (a) {
            view.printMainMenu();
            switch (scanner.nextInt()) {
                case 1 -> departmentMenu();
                case 2 -> postMenu();
                case 3 -> employeeMenu();
                case 4 -> reportMenu();
                case 5 -> a = false;
                default -> def();
            }
        }
    }

    private void departmentMenu() {
        boolean a = true;
        while (a) {
            view.printDepartmentMenu();
            switch (scanner.nextInt()) {
                case 1 -> operation.getReport().departments();
                case 2 -> {
                    System.out.println("Введите название отдела");
                    scanner.nextLine();
                    operation.createDepartment(scanner.nextLine());
                    System.out.println("Отдел создан!");
                }
                case 3 -> a = false;
                default -> def();
            }
        }

    }

    private void departmentEditMenu() {
        boolean a = true;
        while (a) {
            view.printDepartmentEditMenu();
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Введите id отдела который хотите отредактировать:");
                    operation.setDepartment(campaign.data.getDepartments().get(operation.getSearch().searchIndexDepartment(campaign.data.getDepartments(), scanner.nextInt())));
                    editDepartment();
                }
                case 2 -> operation.deleteDepartment();
                case 3 -> a = false;
                default -> def();
            }
        }
    }

    private void editDepartment() {
        boolean a = true;
        while (a) {
            view.printEditDepartment();
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Введите название отдела:");
                    operation.editDepartmentName(scanner.nextLine());
                    System.out.println("Название отдела изменено!");
                }
                case 2 -> {
                    System.out.println("Ведите id сотрдуника отдела, которго хотите назначить руководителем:");
                    operation.editDepartmentChief(scanner.nextInt());
                    System.out.println("Новый руководитель назначен!");
                }
                case 3 -> a = false;
                default -> def();
            }
        }

    }

    private void postMenu() {
        boolean a = true;
        while (a) {
            view.printPostMenu();
            switch (scanner.nextInt()) {
                case 1 -> operation.getReport().listPosts();
                case 2 -> {
                    System.out.println("Введите название должности");
                    operation.createPost(scanner.nextLine());
                    System.out.println("Должность создана");
                }
                case 3 -> a = false;
                default -> def();
            }
        }
    }

    private void postEditMenu() {
        boolean a = true;
        while (a) {
            view.printPostEditMenu();
            switch (scanner.nextInt()) {
                case 1 -> operation.editPost();
                case 2 -> operation.deletePost();
                case 3 -> a = false;
                default -> def();
            }
        }
    }

    private void employeeMenu() {
        boolean a = true;
        while (a) {
            view.printEmployeeMenu();
            switch (scanner.nextInt()) {
                case 1 -> operation.getReport().listEmployees();
                case 2 -> searchEmployeeMenu();
                case 3 -> {
                    System.out.println("Введите фамилию");
                    String surname = scanner.next();
                    System.out.println("Введите имя");
                    String name = scanner.next();
                    System.out.println("Введите отчество");
                    String patronymic = scanner.next();
                    operation.createEmployee(surname, name, patronymic);
                }
                case 4 -> a = false;
                default -> def();
            }
        }

    }

    private void employeeEditMenu() {
        boolean a = true;
        while (a) {
            view.printEmployeeEditMenu();
            switch (scanner.nextInt()) {
                case 1 -> operation.editEmployee();
                case 2 -> operation.deleteEmployee();
                case 3 -> a = false;
                default -> def();
            }
        }
    }

    private void reportMenu() {
        boolean a = true;
        while (a) {
            view.printReportMenu();
            switch (scanner.nextInt()) {
                case 1 -> operation.getReport().companyStructure();
                case 2 -> {
                    operation.getReport().averageSalaryCompany();
                    operation.getReport().averageSalaryDepartments();
                }
                case 3 -> operation.getReport().topExpensiveEmployee();
                case 4 -> {
                    try {
                        operation.getReport().topDevoteesEmployee();

                    } catch (NullPointerException e) {
                        System.out.println("Не у всех сотрдуников указана дата трудоустройства");
                    }
                }
                case 5 -> {
                    a = false;
                    scanner.nextLine();
                }
                default -> def();
            }
        }
    }

    private void searchEmployeeMenu() {
        boolean a = true;
        while (a) {
            view.printSearchEmployeeMenu();
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Введите id сотрдуника");
                    int id = scanner.nextInt();
                    try {
                        operation.setEmployee(operation.getSearch().searchEmployeeID(id));
                        employeeEditMenu();
                    } catch (NullPointerException e) {
                        System.out.println("Сотрдуник с id: " + id + " не найден");
                    }
                }
                case 2 -> {
                    System.out.println("Введите ФИО сотрдуника");
                    String FCs = scanner.nextLine();
                    try {
                        operation.setEmployee(operation.takeEmployee(operation.getSearch().searchEmployeeFCs(FCs)));
                        employeeEditMenu();
                    } catch (NullPointerException e) {
                        System.out.println("Сотрдуник: " + FCs + " не найден");
                    }
                }
                case 3 -> {
                    System.out.println("Введите должность сотрдуника");
                    String post = scanner.nextLine();
                    try {
                        operation.getSearch().searchEmployeePost(post);
                    } catch (NullPointerException e) {
                        System.out.println("Должность: " + post + " не найдена");
                    }
                }
                case 4 -> {
                    System.out.println("Введите название отдела");
                    String department = scanner.nextLine();
                    try {
                        operation.getSearch().searchEmployeeDepartment(department);
                    } catch (NullPointerException e) {
                        System.out.println("Отдел: " + department + " не найден");
                    }
                }
                case 5 -> {
                    System.out.println("Введите ФИО руководителя");
                    String chief = scanner.nextLine();
                    try {
                        operation.getSearch().searchEmployeeChief(chief);
                    } catch (NullPointerException e) {
                        System.out.println("Руководитель: " + chief + " не найден");
                        searchEmployeeMenu();
                    }
                }
                case 6 -> a = false;
                default -> def();
            }
        }
    }
}