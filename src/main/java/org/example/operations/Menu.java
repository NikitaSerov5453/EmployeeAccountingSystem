package org.example.operations;

import org.example.campaigns.Campaign;
import org.example.files.Serialized;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    Operation operation = new Operation();
    Campaign campaign;

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
                System.out.println("Редактировать кампанию");
            }
            case 3 -> {
                operation.loadCampaign("1521645586");
                mainMenu();
            }
            default -> def();
        }
    }







    public void createDepartmentMenu() {
        System.out.println("Введите название отдела");
        scanner.nextLine();
        String departmentName = scanner.nextLine();
        operation.createDepartment(departmentName);
        System.out.println("Отдел: " + departmentName + " создан\n");
        mainMenu();
    }

    public void createPostMenu() {
        System.out.println("Введите название должности:");
        scanner.nextLine();
        String postName = scanner.nextLine();
        operation.createPost(postName);
        System.out.println("Должность: " + postName + " создана\n");
        mainMenu();
    }

    public void createEmployeeMenu() {
        System.out.println("Введите фамилию сотрдуника:");
        String surname = scanner.next();
        System.out.println("Введите имя сотрудника:");
        String name = scanner.next();
        System.out.println("Введите отчество сотрдуника:");
        String patronymic = scanner.next();
        operation.createEmployee(surname, name, patronymic);
        mainMenu();
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
                8: Изменить зарплату""");
        switch (scanner.nextInt()) {
            case 1 -> editFCsMenu();
            case 2 -> System.out.println("Изменить дату рождения");
            case 3 -> System.out.println("Изменить пол");
            case 4 -> System.out.println("Изменить номер телефона");
            case 5 -> System.out.println("Изменить отдел");
            case 6 -> System.out.println("Изменить должность");
            case 7 -> System.out.println("Изменить руководителя");
            case 8 -> System.out.println("Изменить зарплату");
            default -> def();
         }
    }

    private void editFCsMenu() {
        System.out.println("""
                1: Изменить фамилию
                2: Изменить имя
                3: Изменить отчество""");
        switch (scanner.nextInt()) {
            case 1 -> System.out.println("Изменить фамилию");
            case 2 -> System.out.println("Изменить имя");
            case 3 -> System.out.println("Изменить отчество");
            default -> def();
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
            case 5 -> System.out.println("Пока!");
            default -> def();
        }
    }

    private void departmentMenu() {
        System.out.println("""
                1: Список отделов
                2: Создать отдел
                3: Редактировать отдел
                4: Удалить отдел
                5: Назад
                """);
        switch (scanner.nextInt()) {
            case 1 -> System.out.println();
            case 2 -> System.out.println("Создать отдел");
            case 3 -> System.out.println("Редактировать отдел");
            case 4 -> System.out.println("Удалить отдел");
            case 5 -> mainMenu();
            default -> def();
        }
    }

    private void postMenu() {
        System.out.println("""
                1: Список должностей
                2: Создать должность
                3: Редактировать должность
                4: Удалить должность
                5: Назад
                """);
        switch (scanner.nextInt()) {
            case 1 -> System.out.println("Список должностей");
            case 2 -> System.out.println("Создать должность");
            case 3 -> System.out.println("Редактировать должность");
            case 4 -> System.out.println("Удалить должность");
            case 5 -> mainMenu();
            default -> def();
        }
    }
    private void employeeMenu() {
        System.out.println("""
                1: Список сотрдуников
                2: Создать сотрдуника
                3: Редактировать сотрдуика
                4: Удалить сотрудника
                5: Назад""");
        switch (scanner.nextInt()) {
            case 1 -> System.out.println("Список сотрдуников");
            case 2 -> createEmployeeMenu();
            case 3 -> editEmployeeMenu();
            case 4 -> System.out.println("Удалить сотрудника");
            case 5 -> mainMenu();
            default -> def();
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
            default -> def();
        }
    }
}
