package org.example.operations;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);

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
            case 1 -> System.out.println("Создать кампанию");
            case 2 -> System.out.println("Редактировать кампанию");
            case 3 -> System.out.println("Загрузить кампанию");
            default -> def();
        }
    }

    public void controlDepartmentMenu() {
        System.out.println("""
                1: Создать отдел
                2: Редактировать отдел
                2: Удалить отдел""");
        switch (scanner.nextInt()) {
            case 1 -> System.out.println("Создать отдел");
            case 2 -> System.out.println("Редактировать отдел");
            case 3 -> System.out.println("Удалить отдел");
            default -> def();
        }
    }

    public void controlPostMenu() {
        System.out.println("""
                 1: Создать должность
                 2: Редактировать должность
                 2: Удалить должность""");
        switch (scanner.nextInt()) {
            case 1 -> System.out.println("Создать должность");
            case 2 -> System.out.println("Редактировать должность");
            case 3 -> System.out.println("Удалить должность");
            default -> def();
        }
    }

    public void controlEmployeeMenu() {
        System.out.println("""
                1: Создать сотрдуника
                2: Редактировать сотрдуика
                3: Удалить сотрудника""");
        switch (scanner.nextInt()) {
            case 1 -> System.out.println("Создать сотрдуника");
            case 2 -> System.out.println("Редактировать сотрдуика");
            case 3 -> System.out.println("Удалить сотрудника");
            default -> def();
        }
    }

    public void createCompanyMenu() {
        System.out.println("Укажите название кампании");
        //метод создания названия кампании
        System.out.println("Ваша кампания создана!");
    }

    public void createDepartmentMenu() {
        System.out.println("Введите название отдела");
        //метод создания названия отдела
        System.out.println("Отдел создан");
    }

    public void createPostMenu() {
        System.out.println("Введите название должности");
        //метод создания названия должности
        System.out.println("Должность создана");
    }

    public void createEmployeeMenu() {

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
    }

    private void editFCsMenu() {
        System.out.println("""
                1: Изменить фамилию
                2: Изменить имя
                3: Изменить отчество""");
    }




}
