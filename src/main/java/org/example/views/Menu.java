package org.example.views;

import org.example.campaigns.Campaign;
import org.example.files.Serialized;
import org.example.operations.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu  {

    private final Scanner scanner = new Scanner(System.in);
    private Operation operation = new Operation();

    private final Search search = new Search();
    private final OperationEmployee operationEmployee = operation.getOperationEmployee();
    private final OperationDepartment operationDepartment = operation.getOperationDepartment();
    private final OperationPost operationPost = operation.getOperationPost();

    private final View view = new View();
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
        view.printControlCompanyMenu();
        switch (scanner.nextInt()) {
            case 1 -> {
                this.campaign = operation.createCompany();
                mainMenu();
            }
            case 2 -> operation.editCampaign();
            case 3 -> {
                this.campaign = operation.loadCampaign("1234");
                mainMenu();
            }
            default -> {
                def();
                controlCompanyMenu();
            }
        }
    }


    public void editEmployeeMenu() {
        while (true) {
            view.printEditEmployeeMenu();
            switch (scanner.nextInt()) {
                case 1 -> editFCsMenu();
                case 2 -> {
                    try {
                        System.out.println("Введите дату рождения (формат ввода \"dd.MM.yyyy\"):");
                        scanner.nextLine();
                        operationEmployee.editDateOfBirth(scanner.nextLine());
                    } catch (InputMismatchException e) {
                        System.out.println("Неверный формат даты ");
                    }
                }
                case 3 -> {
                    System.out.println("""
                            Выберете необходимый пол:
                            1: Мужской
                            2: Женский""");
                    operationEmployee.editGender(scanner.nextInt());

                }
                case 4 -> {
                    System.out.println("Введите номер телефона:");
                    operationEmployee.editTelephoneNumber(scanner.next());
                }
                case 5 -> {
                    System.out.println("Выберите депортамент из списка:");
                    operationEmployee.editDepartment();
                }
                case 6 -> {
                    System.out.println("Выбирете должность из списка:");
                    operationEmployee.editPost();
                }
                case 7 -> {
                    System.out.println("Укажите зарплату:");
                    operationEmployee.editSalary(scanner.nextInt());
                }
                case 8 -> {
                    try {
                        System.out.println("Введите дату трудоустройства (формат ввода \"dd.MM.yyyy\"):");
                        operationEmployee.editDateOfEmployment(scanner.nextLine());
                    } catch (InputMismatchException e) {
                        System.out.println("Неверный формат даты ");
                    }
                }
                case 9 -> {
                    int index = search.searchIndexEmployee(campaign.getEmployee(), operationEmployee.getEmployee().getEmployeeID());
                    operationEmployee.deleteEmployee(index);
                    operationEmployee.setEmployee(null);
                    System.out.println("Сотрдуник удален");
                    return;

                }
                case 0 -> {
                    return;
                }

                default -> def();
            }
        }
    }

    private void editFCsMenu() {
        while (true) {
            view.printEditFCsMenu();
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Введите фамилию:");
                    scanner.nextLine();
                    operationEmployee.editSurname(scanner.nextLine());
                }
                case 2 -> {
                    System.out.println("Введите имя:");
                    scanner.nextLine();
                    operationEmployee.editName(scanner.nextLine());
                }
                case 3 -> {
                    System.out.println("Введите отчество:");
                    scanner.nextLine();
                    operationEmployee.editPatronymic(scanner.nextLine());
                }
                case 4 -> {
                    return;
                }
                default -> def();
            }
        }
    }

    private void mainMenu() {
        while (true) {
            view.printMainMenu();
            switch (scanner.nextInt()) {
                case 1 -> departmentMenu();
                case 2 -> postMenu();
                case 3 -> employeeMenu();
                case 4 -> reportMenu();
                case 5 -> {
                    Serialized.serialized(operation.getCampaign(), campaign.getCampaignName());
                    return;
                }
                default -> def();
            }
        }
    }

    private void departmentMenu() {
        while (true) {
            view.printDepartmentMenu();
            switch (scanner.nextInt()) {
                case 1 -> {
                    operation.getReport().departments();
                    departmentEditMenu();
                }
                case 2 -> {
                    System.out.println("Введите название отдела");
                    scanner.nextLine();
                    operation.createDepartment(scanner.nextLine());
                    System.out.println("Отдел создан!");
                }
                case 3 -> {
                    return;
                }
                default -> def();
            }
        }
    }

    private void departmentEditMenu() {
        while (true) {
            view.printDepartmentEditMenu();
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Введите id отдела который хотите редактировать:");
                    try {
                        int index = search.searchIndexDepartment(campaign.getDepartments(), scanner.nextInt());
                        operationDepartment.setDepartment(campaign.getDepartments().get(index));
                        System.out.println(operationDepartment.getDepartment());
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Неверно указан id отдела");
                        break;
                    }
                    editDepartment();
                }
                case 2 -> {
                    return;
                }
                default -> def();
            }
        }
    }

    private void editDepartment() {
        while (true) {
            view.printEditDepartment();
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Введите название отдела:");
                    scanner.nextLine();
                    if (operationDepartment.getDepartment() != null) {
                        operationDepartment.getDepartment().setDepartmentName(scanner.nextLine());
                        System.out.println(operationDepartment.getDepartment());
                    } else {
                        System.out.println("Отдел не выбран");
                    }
                    System.out.println("Название отдела изменено!");
                }
                case 2 -> {
                    System.out.println("Ведите id сотрдуника отдела, которго хотите назначить руководителем:");
                    int idEmployee = scanner.nextInt();
                    try {
                        if (operationDepartment.getDepartment() != null) {
                            operationDepartment.getDepartment().setChief(operationDepartment.getDepartment().getEmployee().get(idEmployee));
                            System.out.println("Новый руководитель назначен!");
                        } else {
                            System.out.println("Отдел не выбран");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Неверно указан id сотрдуника");
                    }
                }
                case 3 -> {
                    //Удалить сотрдуника из отдела
                }
                case 4 -> {
                    int index = search.searchIndexDepartment(campaign.getDepartments(), operationDepartment.getDepartment().getDepartmentID());
                    operationDepartment.deleteDepartment(index);
                    operationDepartment.setDepartment(null);
                    System.out.println("Отдел удален");
                    return;
                }
                case 5 -> {
                    return;
                }
                default -> def();
            }
        }

    }

    private void postMenu() {
        while (true) {
            view.printPostMenu();
            switch (scanner.nextInt()) {
                case 1 -> {
                    operation.getReport().listPosts();
                    postEditMenu();
                }
                case 2 -> {
                    System.out.println("Введите название должности");
                    scanner.nextLine();
                    operation.createPost(scanner.nextLine());
                    System.out.println("Должность создана");
                }
                case 3 -> {
                    return;
                }
                default -> def();
            }
        }
    }

    private void postEditMenu() {
        while (true) {
            view.printPostEditMenu();
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Введите id должности, которую хотите редактировать");
                    try {
                        int index = search.searchIndexPost(campaign.getPosts(), operationPost.getPost().getPostID());
                        operationPost.setPost(campaign.getPosts().get(index));
                        System.out.println(operationPost.getPost());
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Неверно указан id должности");
                        break;
                    }

                    editPost();
                }
                case 2 -> {
                    return;
                }
                default -> def();
            }
        }
    }

    private void editPost() {
        while (true) {
            view.printEditPost();
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Введите навание должности:");
                    scanner.nextLine();
                    if (operationPost.getPost() != null) {
                        operationPost.getPost().setPostName(scanner.nextLine());
                        System.out.println(operationPost.getPost());
                    } else {
                        System.out.println("Должность не выбрана");
                    }
                    System.out.println("Название должности изменено");
                }
                case 2 -> {
                    int index = search.searchIndexPost(campaign.getPosts(), operationPost.getPost().getPostID());
                    operationPost.deletePost(index);
                    operationPost.setPost(null);
                    System.out.println("Должность удалена");
                    return;
                }
                case 3 -> {
                    return;
                }
                default -> def();
            }
        }
    }

    private void employeeMenu() {
        while (true) {
            view.printEmployeeMenu();
            switch (scanner.nextInt()) {
                case 1 -> {
                    operation.getReport().listEmployees();
                    employeeEditMenu();
                }
                case 2 -> searchEmployeeMenu();
                case 3 -> {
                    System.out.println("Введите фамилию");
                    String surname = scanner.next();
                    System.out.println("Введите имя");
                    String name = scanner.next();
                    System.out.println("Введите отчество");
                    String patronymic = scanner.next();
                    System.out.println("Введите дату рождения (формат ввода \"dd.MM.yyyy\"):");
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                    scanner.nextLine();
                    LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);
                    operation.createEmployee(surname, name, patronymic, dateOfBirth);
                }
                case 4 -> {
                    return;
                }
                default -> def();
            }
        }

    }

    private void employeeEditMenu() {
        while (true) {
            view.printEmployeeEditMenu();
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Введите id сотрудника которого хотите редактировать:");
                    try {
                        int index = search.searchIndexEmployee(campaign.getEmployee(), scanner.nextInt());
                        operationEmployee.setEmployee(campaign.getEmployee().get(index));
                        System.out.println(operationEmployee.getEmployee());
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Неверно указан id сотрдуника");
                        break;
                    }
                    editEmployeeMenu();
                }
                case 2 -> {
                    return;
                }
                default -> def();
            }
        }
    }

    private void reportMenu() {
        while (true) {
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
                    return;
                }
                default -> def();
            }
        }
    }

    private void searchEmployeeMenu() {
        while (true) {
            view.printSearchEmployeeMenu();
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Введите id сотрдуника");
                    int id = scanner.nextInt();
                    try {
                        operationEmployee.setEmployee(operation.getSearch().searchEmployeeID(id));
                        employeeEditMenu();
                    } catch (NullPointerException e) {
                        System.out.println("Сотрдуник с id: " + id + " не найден");
                    }
                }
                case 2 -> {
                    System.out.println("Введите ФИО сотрдуника");
                    String FCs = scanner.nextLine();
                    try {
                        operationEmployee.setEmployee(operationEmployee.takeEmployee(operation.getSearch().searchEmployeeChief(FCs)));
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
                case 6 -> {
                    return;
                }
                default -> def();
            }
        }
    }
}