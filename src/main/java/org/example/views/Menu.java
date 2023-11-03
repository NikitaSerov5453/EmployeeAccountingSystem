package org.example.views;

import org.example.campaigns.Campaign;
import org.example.operations.*;

import java.io.Serializable;
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
        new Thread(() -> {
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
        }).start();
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
        new Thread(() -> {
            while (true) {
                switch (scanner.nextInt()) {
                    case 1 -> editFCsMenu();
                    case 2 -> {
                        operation.getOperationEmployee().editDateOfBirth();
                        editEmployeeMenu();
                    }
                    case 3 -> {
                        operation.getOperationEmployee().editGender();
                        editEmployeeMenu();
                    }
                    case 4 -> {
                        operation.getOperationEmployee().editTelephoneNumber();
                        editEmployeeMenu();
                    }
                    case 5 -> {
                        operation.getOperationEmployee().editDepartment();
                        editEmployeeMenu();
                    }
                    case 6 -> {
                        operation.getOperationEmployee().editPost();
                        editEmployeeMenu();
                    }
                    case 7 -> {
                        operation.getOperationEmployee().editChief();
                        editEmployeeMenu();
                    }
                    case 8 -> {
                        operation.getOperationEmployee().editSalary();
                        editEmployeeMenu();
                    }
                    case 9 -> {
                        operation.getOperationEmployee().deleteEmployee();
                        employeeMenu();
                    }

                    default -> {
                        def();
                        editEmployeeMenu();
                    }
                }
            }
        }).start();

    }

    private void editFCsMenu() {
        System.out.println("""
                1: Изменить фамилию
                2: Изменить имя
                3: Изменить отчество
                4: Назад""");
        new Thread(() -> {
            while (true) {
                switch (scanner.nextInt()) {
                    case 1 -> {
                        operation.getOperationEmployee().editSurname();
                        editFCsMenu();
                    }
                    case 2 -> {
                        operation.getOperationEmployee().editName();
                        editFCsMenu();
                    }
                    case 3 -> {
                        operation.getOperationEmployee().editPatronymic();
                        editFCsMenu();
                    }
                    case 4 -> editEmployeeMenu();
                    default -> {
                        def();
                        editFCsMenu();
                    }
                }
            }
        }).start();
    }

    private void mainMenu() {
        System.out.println("""
                1: Отделы
                2: Должности
                3: Сотрдуники
                4: Отчеты
                5: Закрыть программу""");
        new Thread(() -> {
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
        }).start();
    }

    private void departmentMenu() {
        System.out.println("""
                1: Список отделов
                2: Создать отдел
                3: Назад
                """);
        new Thread(() -> {
            while (true) {
                switch (scanner.nextInt()) {
                    case 1 -> {
                        operation.getReport().departments();
                        departmentMenu();
                    }
                    case 2 -> {
                        System.out.println("Введите название отдела");
                        scanner.nextLine();
                        operation.getOperationDepartment().createDepartment(scanner.nextLine());
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
        }).start();

    }

    private void departmentEditMenu() {
        System.out.println("""
                1: Редактировать отдел
                2: Удалить отдел
                3: Назад""");
        new Thread(() -> {
            while (true) {
                switch (scanner.nextInt()) {
                    case 1 -> {
                        System.out.println("Введите id отдела который хотите отредактировать:");
                        operation.getOperationDepartment().setDepartment(campaign.data.getDepartments().get(operation.getSearch().searchIndexDepartment(campaign.data.getDepartments(), scanner.nextInt())));
                        editDepartment();
                    }
                    case 2 -> {
                        operation.getOperationDepartment().deleteDepartment();
                        departmentMenu();
                    }
                    case 3 -> departmentMenu();
                    default -> {
                        def();
                        departmentEditMenu();
                    }
                }
            }
        }).start();

    }

    private void editDepartment() {
        System.out.println("""
                1: Изменить название отдела
                2: Изменить руководителя отдела
                3: Назад""");
        new Thread(() -> {
            while (true) {
                switch (scanner.nextInt()) {
                    case 1 -> {
                        System.out.println("Введите название отдела:");
                        operation.getOperationDepartment().editDepartmentName(scanner.nextLine());
                        System.out.println("Название отдела изменено!");
                        editDepartment();
                    }
                    case 2 -> {
                        System.out.println("Ведите id сотрдуника отдела, которго хотите назначить руководителем:");
                        operation.getOperationDepartment().editDepartmentChief(scanner.nextInt());
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
        }).start();

    }

    private void postMenu() {
        System.out.println("""
                1: Список должностей
                2: Создать должность
                3: Назад
                """);
        new Thread(() -> {
            while (true) {
                switch (scanner.nextInt()) {
                    case 1 -> {
                        operation.getReport().posts();
                        postMenu();
                    }
                    case 2 -> {
                        operation.getOperationPost().createPostMenu();
                        postMenu();
                    }
                    case 3 -> mainMenu();
                    default -> {
                        def();
                        postMenu();
                    }
                }
            }
        }).start();
    }

    private void postEditMenu() {
        System.out.println("""
                1: Редактировать должность
                2: Удалить должность
                3: Назад""");
        new Thread(() -> {
            while (true) {
                switch (scanner.nextInt()) {
                    case 1 -> {
                        operation.getOperationPost().editPost();
                        postMenu();
                    }
                    case 2 -> {
                        operation.getOperationPost().deletePost();
                        postMenu();
                    }
                    case 3 -> postMenu();
                    default -> {
                        def();
                        postEditMenu();
                    }
                }
            }
        }).start();
    }

    private void employeeMenu() {
        System.out.println("""
                1: Список сотрдуников
                2: Создать сотрдуника
                3: Назад""");
        new Thread(() -> {
            while (true) {
                switch (scanner.nextInt()) {
                    case 1 -> {
                        operation.getReport().employees();
                        employeeMenu();
                    }
                    case 2 -> {
                        operation.getOperationEmployee().createEmployeeMenu();
                        employeeMenu();
                    }
                    case 3 -> mainMenu();
                    default -> {
                        def();
                        employeeMenu();
                    }
                }
            }
        }).start();

    }

    private void employeeEditMenu() {
        System.out.println("""
                1: Редактировать сотрдуника
                2: Удалить сотрдуника
                3: Назад""");
        new Thread(() -> {
            while (true) {
                switch (scanner.nextInt()) {
                    case 1 -> {
                        operation.getOperationEmployee().editEmployee();
                        employeeMenu();
                    }
                    case 2 -> {
                        operation.getOperationEmployee().deleteEmployee();
                        employeeMenu();
                    }
                    case 3 -> postMenu();
                    default -> {
                        def();
                        employeeEditMenu();
                    }
                }
            }
        }).start();
    }

    private void reportMenu() {
        System.out.println("""
                1: Структура организации(Отдел, Руководитель)
                2: Средняя зарплата(По органицации|По отделам)
                3: Топ 10 самых дорогох сотрудников по ЗП
                4: Топ 10 самых преданных сотрдуников по кол-ву лет в фирме
                5: Назад""");
        new Thread(() -> {
            while (true) {
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
        }).start();
    }
}