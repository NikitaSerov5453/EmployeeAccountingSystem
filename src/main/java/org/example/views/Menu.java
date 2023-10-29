package org.example.views;

import org.example.campaigns.Campaign;
import org.example.operations.*;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    Operation operation = new Operation();
    OperationEmployee operationEmployee = new OperationEmployee();
    OperationDepartment operationDepartment = new OperationDepartment();
    OperationPost operationPost = new OperationPost();
    Report report = new Report();

    public Menu() {

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
        switch (scanner.nextInt()) {
            case 1 -> {
                operation.createCompany();
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
        switch (scanner.nextInt()) {
            case 1 -> editFCsMenu();
            case 2 -> {
                operationEmployee.editDateOfBirth();
                editEmployeeMenu();
            }
            case 3 -> {
                operationEmployee.editGender();
                editEmployeeMenu();
            }
            case 4 -> {
                operationEmployee.editTelephoneNumber();
                editEmployeeMenu();
            }
            case 5 -> {
                operationEmployee.editDepartment();
                editEmployeeMenu();
            }
            case 6 -> {
                operationEmployee.editPost();
                editEmployeeMenu();
            }
            case 7 -> {
                operationEmployee.editChief();
                editEmployeeMenu();
            }
            case 8 -> {
                operationEmployee.editSalary();
                editEmployeeMenu();
            }
            case 9 -> {
                operationEmployee.deleteEmployee();
                employeeMenu();
            }

            default -> {
                def();
                editEmployeeMenu();
            }
         }
    }

    private void editFCsMenu() {
        System.out.println("""
                1: Изменить фамилию
                2: Изменить имя
                3: Изменить отчество
                4: Назад""");
        switch (scanner.nextInt()) {
            case 1 -> {
                operationEmployee.editSurname();
                editFCsMenu();
            }
            case 2 -> {
                operationEmployee.editName();
                editFCsMenu();
            }
            case 3 -> {
                operationEmployee.editPatronymic();
                editFCsMenu();
            }
            case 4 -> editEmployeeMenu();
            default -> {
                def();
                editFCsMenu();
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

    private void departmentMenu() {
        System.out.println("""
                1: Список отделов
                2: Создать отдел
                3: Назад
                """);
        switch (scanner.nextInt()) {
            case 1 -> {
                report.departments();
                departmentMenu();
            }
            case 2 -> {
                operationDepartment.createDepartmentMenu();
                departmentMenu();
            }
            case 5 -> mainMenu();
            default -> {
                def();
                departmentMenu();
            }
        }
    }

    private void departmentEditMenu() {
        System.out.println("""
                1: Редактировать отдел
                2: Удалить отдел
                3: Назад""");
        switch (scanner.nextInt()) {
            case 1 -> {
                operationDepartment.editDepartment();
                departmentMenu();
            }
            case 2 -> {
                operationDepartment.deleteDepartment();
                departmentMenu();
            }
            case 3 -> departmentMenu();
            default -> {
                def();
                departmentEditMenu();
            }
        }
    }

    private void editDepartment() {
        System.out.println("""
                1: Изменить название отдела
                2: Изменить руководителя отдела
                3: Назад""");
        switch (scanner.nextInt()) {
            case 1 -> {
                operationDepartment.editDepartmentName(scanner.nextLine());
                System.out.println("Название отдела изменено");
                editDepartment();
            }
            case 2 -> operationDepartment.editDepartmentChief();
            case 3 -> departmentEditMenu();
            default -> {
                def();
                editDepartment();
            }
        }
    }

    private void postMenu() {
        System.out.println("""
                1: Список должностей
                2: Создать должность
                3: Назад
                """);
        switch (scanner.nextInt()) {
            case 1 -> {
                report.posts();
                postMenu();
            }
            case 2 -> {
                operationPost.createPostMenu();
                postMenu();
            }
            case 3 -> mainMenu();
            default -> {
                def();
                postMenu();
            }
        }
    }

    private void postEditMenu() {
        System.out.println("""
                1: Редактировать должность
                2: Удалить должность
                3: Назад""");
        switch (scanner.nextInt()) {
            case 1 -> {
                operationPost.editPost();
                postMenu();
            }
            case 2 -> {
                operationPost.deletePost();
                postMenu();
            }
            case 3 -> postMenu();
            default -> {
                def();
                postEditMenu();
            }
        }
    }

    private void employeeMenu() {
        System.out.println("""
                1: Список сотрдуников
                2: Создать сотрдуника
                3: Назад""");
        switch (scanner.nextInt()) {
            case 1 -> {
                report.employees();
            }
            case 2 -> {
                operationEmployee.createEmployeeMenu();
                employeeMenu();
            }
            case 3 -> mainMenu();
            default -> {
                def();
                employeeMenu();
            }
        }
    }

    private void employeeEditMenu() {
        System.out.println("""
                1: Редактировать сотрдуника
                2: Удалить сотрдуника
                3: Назад""");
        switch (scanner.nextInt()) {
            case 1 -> {
                operationEmployee.editEmployee();
                employeeMenu();
            }
            case 2 -> {
                operationEmployee.deleteEmployee();
                employeeMenu();
            }
            case 3 -> postMenu();
            default -> {
                def();
                employeeEditMenu();
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
        switch (scanner.nextInt()) {
            case 1 -> System.out.println("Структура организации");
            case 2 -> System.out.println("Средняя зарплата");
            case 3 -> System.out.println("Топ 10 самых дорогох сотрудников");
            case 4 -> System.out.println("Топ 10 самых преданных сотрдуников");
            case 5 -> mainMenu();
            default -> {
                def();
                reportMenu();
            }
        }
    }
}