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
        System.out.println("""
                1: Создать кампанию
                2: Редактировать кампанию
                3: Загрузить кампанию""");
        while (true) {
            switch (scanner.nextInt()) {
                case 1 -> {
                    this.campaign = operation.createCompany();
                    mainMenu();
                }
                case 2 -> {
                    operation.editCampaign();
                }
                case 3 -> {
                    operation.loadCampaign("1521645586");
                    mainMenu();
                }
                default -> {
                    def();
                    controlCompanyMenu();
                }
            }
        }
    }



    public void editEmployeeMenu() {
        System.out.println("""
                1: Изменить ФИО
                2: Изменить дату рождения
                3: Изменить пол
                4: Изменить номер телефона
                5: Изменить отдел
                6: Изменить должность
                7: Изменить руководителя
                8: Изменить зарплату
                9: Удалить сотрудника""");
        while (true) {
            switch (scanner.nextInt()) {
                case 1 -> editFCsMenu();
                case 2 -> {
                    operation.editDateOfBirth();
                    editEmployeeMenu();
                }
                case 3 -> {
                    operation.editGender();
                    editEmployeeMenu();
                }
                case 4 -> {
                    operation.editTelephoneNumber();
                    editEmployeeMenu();
                }
                case 5 -> {
                    operation.editDepartment();
                    editEmployeeMenu();
                }
                case 6 -> {
                    operation.editPost();
                    editEmployeeMenu();
                }
                case 7 -> {
                    operation.editChief();
                    editEmployeeMenu();
                }
                case 8 -> {
                    operation.editSalary();
                    editEmployeeMenu();
                }
                case 9 -> {
                    operation.deleteEmployee();
                    employeeMenu();
                }

                default -> {
                    def();
                    editEmployeeMenu();
                }
            }
        }
    }

    private void editFCsMenu() {
        System.out.println("""
                1: Изменить фамилию
                2: Изменить имя
                3: Изменить отчество
                4: Назад""");
        while (true) {
            switch (scanner.nextInt()) {
                case 1 -> {
                    operation.editSurname();
                    editFCsMenu();
                }
                case 2 -> {
                    operation.editName();
                    editFCsMenu();
                }
                case 3 -> {
                    operation.editPatronymic();
                    editFCsMenu();
                }
                case 4 -> editEmployeeMenu();
                default -> {
                    def();
                    editFCsMenu();
                }
            }
        }
    }

    private void mainMenu() {
        System.out.println("""
                1: Отделы
                2: Должности
                3: Сотрдуники
                4: Отчеты
                5: Закрыть программу""");
        while (true) {
            switch (scanner.nextInt()) {
                case 1 -> departmentMenu();
                case 2 -> postMenu();
                case 3 -> employeeMenu();
                case 4 -> reportMenu();
                case 5 -> System.out.println("До свидания!");
                default -> {
                    def();
                    mainMenu();
                }
            }
        }
    }

    private void departmentMenu() {
        System.out.println("""
                1: Список отделов
                2: Создать отдел
                3: Назад
                """);
        while (true) {
            switch (scanner.nextInt()) {
                case 1 -> {
                    operation.getReport().departments();
                    departmentMenu();
                }
                case 2 -> {
                    System.out.println("Введите название отдела");
                    scanner.nextLine();
                    operation.createDepartment(scanner.nextLine());
                    System.out.println("Отдел создан!");
                    departmentMenu();
                }
                case 3 -> mainMenu();
                default -> {
                    def();
                    departmentMenu();
                }
            }
        }

    }

    private void departmentEditMenu() {
        System.out.println("""
                1: Редактировать отдел
                2: Удалить отдел
                3: Назад""");
        while (true) {
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Введите id отдела который хотите отредактировать:");
                    operation.setDepartment(campaign.data.getDepartments().get(operation.getSearch().searchIndexDepartment(campaign.data.getDepartments(), scanner.nextInt())));
                    editDepartment();
                }
                case 2 -> {
                    operation.deleteDepartment();
                    departmentMenu();
                }
                case 3 -> departmentMenu();
                default -> {
                    def();
                    departmentEditMenu();
                }
            }
        }
    }

    private void editDepartment() {
        System.out.println("""
                1: Изменить название отдела
                2: Изменить руководителя отдела
                3: Назад""");
        while (true) {
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Введите название отдела:");
                    operation.editDepartmentName(scanner.nextLine());
                    System.out.println("Название отдела изменено!");
                    editDepartment();
                }
                case 2 -> {
                    System.out.println("Ведите id сотрдуника отдела, которго хотите назначить руководителем:");
                    operation.editDepartmentChief(scanner.nextInt());
                    System.out.println("Новый руководитель назначен!");
                    editDepartment();
                }
                case 3 -> departmentEditMenu();
                default -> {
                    def();
                    editDepartment();
                }
            }
        }

    }

    private void postMenu() {
        System.out.println("""
                1: Список должностей
                2: Создать должность
                3: Назад
                """);
        while (true) {
            switch (scanner.nextInt()) {
                case 1 -> {
                    operation.getReport().listPosts();
                    postMenu();
                }
                case 2 -> {

                    postMenu();
                }
                case 3 -> mainMenu();
                default -> {
                    def();
                    postMenu();
                }
            }
        }
    }

    private void postEditMenu() {
        System.out.println("""
                1: Редактировать должность
                2: Удалить должность
                3: Назад""");
        while (true) {
            switch (scanner.nextInt()) {
                case 1 -> {
                    operation.editPost();
                    postMenu();
                }
                case 2 -> {
                    operation.deletePost();
                    postMenu();
                }
                case 3 -> postMenu();
                default -> {
                    def();
                    postEditMenu();
                }
            }
        }
    }

    private void employeeMenu() {
        System.out.println("""
                1: Список сотрдуников
                2: Поиск сотрдуника
                3: Создать сотрдуника
                4: Назад""");
        while (true) {
            switch (scanner.nextInt()) {
                case 1 -> {
                    operation.getReport().listEmployees();
                    employeeMenu();
                }
                case 2 -> {
                    searchEmployeeMenu();
                }
                case 3 -> {

                    employeeMenu();
                }
                case 4 -> mainMenu();
                default -> {
                    def();
                    employeeMenu();
                }
            }
        }

    }

    private void employeeEditMenu() {
        System.out.println("""
                1: Редактировать сотрдуника
                2: Удалить сотрдуника
                3: Назад""");
        while (true) {
            switch (scanner.nextInt()) {
                case 1 -> {
                    operation.editEmployee();
                    employeeMenu();
                }
                case 2 -> {
                    operation.deleteEmployee();
                    employeeMenu();
                }
                case 3 -> postMenu();
                default -> {
                    def();
                    employeeEditMenu();
                }
            }
        }
    }

    private void reportMenu() {
        System.out.println("""
                1: Структура организации(Отдел, Руководитель)
                2: Средняя зарплата(По органицации|По отделам)
                3: Топ 10 самых дорогох сотрудников по ЗП
                4: Топ 10 самых преданных сотрдуников по кол-ву лет в фирме
                5: Назад""");
        while (true) {
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Структура организации");
                }
                case 2 -> {
                    System.out.println("Средняя зарплата");
                }
                case 3 -> {
                    System.out.println("Топ 10 самых дорогох сотрудников");
                }
                case 4 -> {
                    System.out.println("Топ 10 самых преданных сотрдуников");
                }
                case 5 -> mainMenu();
                default -> {
                    def();
                    reportMenu();
                }
            }
        }
    }

    private void searchEmployeeMenu() {
        System.out.println("""
                Поиск сотрдуника
                1: Поиск по id
                2: Поиск по ФИО
                3: Поиск по должности
                4: Поиск по отделу
                5: Поиск по руководителю
                6: Назад""");
        while (true) {
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Введите id сотрдуника");
                    int id = scanner.nextInt();
                    try {
                        operation.setEmployee(operation.getSearch().searchEmployeeID(id));
                        employeeEditMenu();
                    } catch (NullPointerException e) {
                        System.out.println("Сотрдуник с id: " + id + " не найден");
                        searchEmployeeMenu();
                    }
                }
                case 2 -> {
                    System.out.println("Введите ФИО сотрдуника");
                    String FCs = scanner.nextLine();
                    try {
                        operation.setEmployee(operation.takeEmployee(operation.getSearch().searchEmployeeFCs(FCs)));
                        employeeEditMenu();
                    } catch (NullPointerException e) {
                        System.out.println("Сотрдуник с ФИО: " + FCs + " не найден");
                        searchEmployeeMenu();
                    }
                }
                case 3 -> {
                    System.out.println("Введите должность сотрдуника");
                    String post = scanner.nextLine();
                    try {
                        operation.getSearch().searchEmployeePost(post);
                    } catch (NullPointerException e) {
                        System.out.println("Должность: " + post + " не найдена");
                        searchEmployeeMenu();
                    }
                }
                case 4 -> {
                    operation.getSearch().searchEmployeeDepartment();
                }
                case 5 -> {
                    operation.getSearch().searchEmployeeChief();
                }
                case 6 -> employeeMenu();
                default -> def();
            }
        }
    }


}