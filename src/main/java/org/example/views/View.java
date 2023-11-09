package org.example.views;

import org.example.campaigns.Employee;

import java.util.HashSet;

public class View {

    public View() {

    }

    public void printHashSet(HashSet<Employee> hashSet) {
        int counter = 1;
        for (Employee employee : hashSet) {
            System.out.println(counter + ": " + employee);
            counter++;
        }
    }

    public void printReportMenu() {
        System.out.println("""
                1: Структура организации(Отдел|Руководитель)
                2: Средняя зарплата(По органицации|По отделам)
                3: Топ 10 самых дорогох сотрудников по ЗП
                4: Топ 10 самых преданных сотрдуников по кол-ву лет в фирме
                5: Назад""");
    }

    public void printControlCompanyMenu() {
        System.out.println("""
                1: Создать кампанию
                2: Редактировать кампанию
                3: Загрузить кампанию""");
    }

    public void printEditEmployeeMenu() {
        System.out.println("""
                1: Изменить ФИО
                2: Изменить дату рождения
                3: Изменить пол
                4: Изменить номер телефона
                5: Изменить отдел
                6: Изменить должность
                7: Изменить зарплату
                8: Изменить дату трудоустройства
                9: Удалить сотрудника
                0: Назад""");
    }

    public void printEditFCsMenu() {
        System.out.println("""
                1: Изменить фамилию
                2: Изменить имя
                3: Изменить отчество
                4: Назад""");
    }

    public void printMainMenu() {
        System.out.println("""
                1: Отделы
                2: Должности
                3: Сотрдуники
                4: Отчеты
                5: Закрыть программу""");
    }

    public void printDepartmentMenu() {
        System.out.println("""
                1: Список отделов
                2: Создать отдел
                3: Назад
                """);
    }

    public void printDepartmentEditMenu() {
        System.out.println("""
                1: Редактировать отдел
                2: Назад""");
    }

    public void printEditDepartment() {
        System.out.println("""
                1: Изменить название отдела
                2: Изменить руководителя отдела
                3: Удалить сотрдуника из отдела
                4: Удалить отдел
                5: Назад""");
    }

    public void printPostMenu() {
        System.out.println("""
                1: Список должностей
                2: Создать должность
                3: Назад
                """);
    }

    public void printPostEditMenu() {
        System.out.println("""
                1: Редактировать должность
                2: Назад""");
    }

    public void printEditPost() {
        System.out.println("""
                1: Изменить название должности
                2: Удалить должность
                3: Назад""");
    }

    public void printEmployeeMenu() {
        System.out.println("""
                1: Список сотрдуников
                2: Поиск сотрдуника
                3: Создать сотрдуника
                4: Назад""");
    }

    public void printEmployeeEditMenu() {
        System.out.println("""
                1: Редактировать сотрдуника
                2: Назад""");
    }

    public void printSearchEmployeeMenu() {
        System.out.println("""
                Поиск сотрдуника
                1: Поиск по id
                2: Поиск по ФИО
                3: Поиск по должности
                4: Поиск по отделу
                5: Поиск по руководителю
                6: Назад""");
    }

}
