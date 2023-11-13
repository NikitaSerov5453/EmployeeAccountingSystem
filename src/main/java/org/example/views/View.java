package org.example.views;

import org.example.campaigns.Employee;

import java.util.HashSet;
import java.util.List;

public class View {


    public View() {

    }

    public void printHashSet(HashSet<Employee> hashSet) {
        int counter = 1;
        for (Employee employee : hashSet) {
            System.out.println(counter + ": " +
                    employee.getSurname() + " " +
                    employee.getName() + " " +
                    employee.getPatronymic());
            counter++;
        }
    }

    public void printReportMenu() {
        System.out.println("""
                1: Структура организации(Отдел|Руководитель)
                2: Средняя зарплата(По органицации|По отделам)
                3: Топ 10 самых дорогох сотрудников по ЗП
                4: Топ 10 самых преданных сотрдуников по кол-ву лет в фирме
                0: Назад""");
    }

    public void printControlCompanyMenu() {
        System.out.println("""
                1: Создать кампанию
                2: Загрузить кампанию""");
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
                0: Назад""");
    }

    public void printMainMenu() {
        System.out.println("""
                1: Отделы
                2: Должности
                3: Сотрдуники
                4: Отчеты
                0: Закрыть программу""");
    }

    public void printDepartmentMenu() {
        System.out.println("""
                1: Список отделов
                2: Создать отдел
                0: Назад
                """);
    }

    public void printDepartmentEditMenu() {
        System.out.println("""
                1: Редактировать отдел
                0: Назад""");
    }

    public void printEditDepartment() {
        System.out.println("""
                1: Изменить название отдела
                2: Изменить руководителя отдела
                3: Дабавить должность
                4: Удалить должность из отдела
                5: Удалить сотрдуника из отдела
                6: Удалить отдел
                0: Назад""");
    }

    public void printPostMenu() {
        System.out.println("""
                1: Список должностей
                0: Назад
                """);
    }

    public void printPostEditMenu() {
        System.out.println("""
                1: Редактировать должность
                0: Назад""");
    }

    public void printEditPost() {
        System.out.println("""
                1: Изменить название должности
                2: Удалить должность
                0: Назад""");
    }

    public void printEmployeeMenu() {
        System.out.println("""
                1: Список сотрдуников
                2: Поиск сотрдуника
                3: Создать сотрдуника
                0: Назад""");
    }

    public void printEmployeeEditMenu() {
        System.out.println("""
                1: Редактировать сотрдуника
                0: Назад""");
    }

    public void printSearchEmployeeMenu() {
        System.out.println("""
                Поиск сотрдуника
                1: Поиск по id
                2: Поиск по ФИО
                3: Поиск по должности
                4: Поиск по отделу
                5: Поиск по руководителю
                0: Назад""");
    }

    public static String printChief(Employee chief) {
        if (chief != null) {
            return chief.getSurname() + " " + chief.getName();
        } else {
            return null;
        }
    }

    public void printChooseGender() {
        System.out.println("""
                Выберете необходимый пол:
                1: Мужской
                2: Женский""");
    }

    public void printAllEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println("ID " + employee.getEmployeeID() + " " +
                    employee.getSurname() + " " +
                    employee.getName() + " " +
                    employee.getPatronymic());
        }
    }

    public void printEmployee(Employee employee) {
        System.out.println(employee);
    }

    public void printSetBirthday() {
        System.out.println(Constants.SET_BIRTHDAY);
    }

    public void printErrDataFormat() {
        System.out.println(Constants.ERR_DATA_FORMAT);
    }

    public String backUpPath() {
        return Constants.BACK_UP_PATH;
    }

    public String mainSavePath() {
        return Constants.MAIN_SAVE_PATH;
    }

    public void printSetTelephoneNumber() {
        System.out.println(Constants.SET_TELEPHONE_NUMBER);
    }

    public void printErrDepartmentAvailable() {
        System.out.println(Constants.ERR_DEPARTMENTS_AVAILABLE);
    }

    public void printErrDepartmentSpecified() {
        System.out.println(Constants.ERR_DEPARTMENTS_SPECIFIED);
    }

    public void printErrPostsAvailable() {
        System.out.println(Constants.ERR_POSTS_AVAILABLE);
    }

    public void printSetSalary() {
        System.out.println(Constants.SET_SALARY);
    }

    public void setDateOfEmployment() {
        System.out.println(Constants.SET_DATE_OF_EMPLOYMENT);
    }

    public void printEmployeeDeleted() {
        System.out.println(Constants.EMPLOYEE_DELETED);
    }

    public void printSetSurname() {
        System.out.println(Constants.SET_SURNAME);
    }

    public void printSetName() {
        System.out.println(Constants.SET_NAME);
    }

    public void printSetPatronymic() {
        System.out.println(Constants.SET_PATRONYMIC);
    }

    public void printDepartmentCreated() {
        System.out.println(Constants.DEPARTMENT_CREATED);
    }

    public void printSetIDDepartmentFromEdit() {
        System.out.println(Constants.SET_ID_DEPARTMENT_FROM_EDIT);
    }

    public void printErrIDDepartment() {
        System.out.println(Constants.ERR_ID_DEPARTMENT);
    }

    public void printSetDepartmentName() {
        System.out.println(Constants.SET_DEPARTMENT_NAME);
    }

    public void printErrDepartmentNotSelected() {
        System.out.println(Constants.ERR_DEPARTMENT_NOT_SELECTED);
    }

    public void printDepartmentNameChanged() {
        System.out.println(Constants.DEPARTMENT_NAME_CHANGED);
    }

    public void printNewChiefAppointed() {
        System.out.println(Constants.NEW_CHIEF_APPOINTED);
    }

    public void printSetIDDepartmentEmployeeYouWantAppointChief() {
        System.out.println(Constants.SET_ID_DEPARTMENT_EMPLOYEE_YOU_WANT_APPOINT_CHIEF);
    }

    public void printErrIDEmployee() {
        System.out.println(Constants.ERR_ID_EMPLOYEE);
    }

    public void printSetNamePostYouWantAdd() {
        System.out.println(Constants.SET_NAME_POST_YOU_WANT_ADD);
    }

    public void printPostCreated() {
        System.out.println(Constants.POST_CREATED);
    }

    public void printSetIDPostYouWantDelete() {
        System.out.println(Constants.SET_ID_POST_YOU_WANT_DELETE);
    }

    public void printPostDeleted() {
        System.out.println(Constants.POST_DELETED);
    }

    public void printErrIDPost() {
        System.out.println(Constants.ERR_ID_POST);
    }

    public void printSetIDEmployeeYouWantDeleted() {
        System.out.println(Constants.SET_ID_EMPLOYEE_YOU_WANT_DELETE);
    }

    public void printErrEmployeeAvailable() {
        System.out.println(Constants.ERR_EMPLOYEE_AVAILABLE);
    }

    public void printDepartmentDeleted() {
        System.out.println(Constants.DEPARTMENT_DELETED);
    }

    public void printSetIDPostFromEdit() {
        System.out.println(Constants.SET_ID_POST_FROM_EDIT);
    }

    public void printSetPostName() {
        System.out.println(Constants.SET_POST_NAME);
    }

    public void printErrPostNotSelected() {
        System.out.println(Constants.ERR_POST_NOT_SELECTED);
    }

    public void printPostNameChanged() {
        System.out.println(Constants.POST_NAME_CHANGED);
    }

    public void printSetIDEmployeeFromEdit() {
        System.out.println(Constants.SET_ID_EMPLOYEE_FROM_EDIT);
    }

    public void printErrDateEmployment() {
        System.out.println(Constants.ERR_DATE_EMPLOYMENT);
    }

    public void printSetIDEmployee() {
        System.out.println(Constants.SET_ID_EMPLOYEE);
    }

    public void printErrSetNumber() {
        System.out.println(Constants.ERR_SET_NUMBER);
    }

    public void printSetFCsEmployee() {
        System.out.println(Constants.SET_FCs_EMPLOYEE);
    }

    public void printSetFCsChief() {
        System.out.println(Constants.SET_FCs_CHIEF);
    }

}
