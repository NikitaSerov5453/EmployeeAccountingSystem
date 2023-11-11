package org.example.views;

import org.example.campaigns.Campaign;
import org.example.campaigns.Employee;
import org.example.files.File;
import org.example.files.Serialized;
import org.example.operations.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private Operation operation = new Operation();

    private final Search search = new Search();
    private final OperationEmployee operationEmployee = operation.getOperationEmployee();
    private final OperationDepartment operationDepartment = operation.getOperationDepartment();
    private final OperationPost operationPost = operation.getOperationPost();
    public File file = new File();

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

    public void controlCompanyMenu() {//Создание кампании
        view.printControlCompanyMenu();
        switch (scanner.nextInt()) {
            case 1 -> {
                this.campaign = operation.createCompany();
                mainMenu();
            }
            case 2 -> {
                this.campaign = operation.loadCampaign(file.loadFile());
                mainMenu();
            }
            default -> {
                def();
                controlCompanyMenu();
            }
        }
    }


    public void editEmployeeMenu() {//Редактирование сотрдуника
        while (true) {
            view.printEditEmployeeMenu();
            switch (scanner.nextInt()) {
                case 1 -> editFCsMenu();
                case 2 -> {
                    try {
                        System.out.println("Введите дату рождения (формат ввода \"dd.MM.yyyy\"):");
                        scanner.nextLine();
                        operationEmployee.editDateOfBirth(scanner.nextLine());
                    } catch (DateTimeException e) {
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
                    if (campaign.getDepartments().size() != 0) {

                        System.out.println("Выберите отдел из списка:\n\n" +
                                campaign.getDepartments() +
                                "\n\nВведите id отдела:");
                        int index = search.searchIndexDepartment(campaign.getDepartments(), scanner.nextInt());
                        if (operationEmployee.getEmployee().getDepartment() != null) {
                            operationEmployee.cleanDepartmentAndPost();
                        }
                        operationEmployee.editDepartment(campaign.getDepartments().get(index));
                        campaign.getDepartments().get(index).getEmployee().add(operationEmployee.getEmployee());

                    } else {
                        System.out.println("Нет доступных отделов");
                    }
                }
                case 6 -> {
                    if (operationEmployee.getEmployee().getDepartment() == null) {
                        System.out.println("Не указан отдел");
                    } else if (operationEmployee.getEmployee().getDepartment().getPosts().size() == 0) {
                        System.out.println("Нет доступных должностей");
                    } else {
                        System.out.println("Выбирете должность из списка:\n\n" +
                                operationEmployee.getEmployee().getDepartment().getPosts() +
                                "\n\nВведите id должности");
                        int index = search.searchIndexPost(operationEmployee.getEmployee().getDepartment().getPosts(), scanner.nextInt());
                        operationEmployee.editPost(operationEmployee.getEmployee().getDepartment().getPosts().get(index));
                    }

                }
                case 7 -> {
                    System.out.println("Укажите зарплату:");
                    operationEmployee.editSalary(scanner.nextInt());
                }
                case 8 -> {
                    try {
                        System.out.println("Введите дату трудоустройства (формат ввода \"dd.MM.yyyy\"):");
                        operationEmployee.editDateOfEmployment(scanner.nextLine());
                    } catch (DateTimeException e) {
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

    private void editFCsMenu() {//Редактирование ФИО
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
                case 0 -> {
                    return;
                }
                default -> def();
            }
        }
    }

    private void mainMenu() {//Главное меню
        while (true) {
            view.printMainMenu();
            switch (scanner.nextInt()) {
                case 1 -> departmentMenu();
                case 2 -> postMenu();
                case 3 -> employeeMenu();
                case 4 -> reportMenu();
                case 0 -> {
                    Serialized.serialized(operation.getCampaign(), campaign.getCampaignName(), view.MAIN_SAVE);
                    Serialized.serialized(operation.getCampaign(), campaign.getCampaignID() + "." + campaign.getCampaignName(), view.BACK_UP);
                    return;
                }
                default -> def();
            }
        }
    }

    private void departmentMenu() {//Меню отделов
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
                    operationDepartment.createDepartment(scanner.nextLine());
                    System.out.println("Отдел создан!");
                }
                case 0 -> {
                    return;
                }
                default -> def();
            }
        }
    }

    private void departmentEditMenu() {//выбор отдела для редактирования
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
                case 0 -> {
                    return;
                }
                default -> def();
            }
        }
    }

    private void editDepartment() { //Редактирование отдела
        while (true) {
            view.printEditDepartment();
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Введите название отдела:");
                    scanner.nextLine();
                    if (operationDepartment.getDepartment() != null) {
                        operationDepartment.editDepartmentName(scanner.nextLine());
                        System.out.println(operationDepartment.getDepartment());
                    } else {
                        System.out.println("Отдел не выбран");
                    }
                    System.out.println("Название отдела изменено!");
                }
                case 2 -> {
                    System.out.println("Ведите id сотрдуника отдела, которго хотите назначить руководителем:\n" +
                            operationDepartment.getDepartment().getEmployee() + '\n');
                    try {
                        if (operationDepartment.getDepartment() != null) {
                            int index = search.searchIndexEmployee(operationDepartment.getDepartment().getEmployee(), scanner.nextInt());
                            operationDepartment.editDepartmentChief(operationDepartment.getDepartment().getEmployee().get(index));
                            System.out.println("Новый руководитель назначен!");
                        } else {
                            System.out.println("Отдел не выбран");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Неверно указан id сотрдуника");
                    }
                }
                case 3 -> {
                    System.out.println("Введите название должности которую хотите добавить:");
                    operationPost.setDepartment(operationDepartment.getDepartment());
                    scanner.nextLine();
                    operationPost.createPost(scanner.nextLine());
                    System.out.println("Должность создана");
                }
                case 4 -> {
                    System.out.println(operationDepartment.getDepartment().getPosts());
                    System.out.println("Введите id должности которую хотите удалить");
                    int postID = scanner.nextInt();
                    if (operationDepartment.getDepartment().getPosts().size() != 0) {
                        int index = search.searchIndexPost(operationDepartment.getDepartment().getPosts(), postID);
                        if (index != -1) {
                            operationEmployee.deletePostFromEmployee(campaign.getEmployee(), postID);
                            operationDepartment.getDepartment().getPosts().remove(index);
                            System.out.println("Должность удалена");
                        } else {
                            System.out.println("Должность с таким id не найдена");
                        }
                    } else {
                        System.out.println("Нет доступных должностей");
                    }
                }
                case 5 -> {
                    System.out.println(operationDepartment.getDepartment().getEmployee());
                    System.out.println("Введите id сотрдуника которого хотите удалить");
                    int employeeID = scanner.nextInt();
                    if (operationDepartment.getDepartment().getEmployee().size() != 0) {
                        int index = search.searchIndexEmployee(operationDepartment.getDepartment().getEmployee(), employeeID);
                        if (index != -1) {
                            operationDepartment.getDepartment().getEmployee().get(index).setDepartment(null);
                            operationDepartment.getDepartment().getEmployee().get(index).setPost(null);
                            operationDepartment.getDepartment().getEmployee().remove(index);
                            System.out.println("Сотрудник удален");
                        } else {
                            System.out.println("Сотрудник с таким id не найден");
                        }
                    } else {
                        System.out.println("Нет доступных сотрудников");
                    }
                }
                case 6 -> {
                    int departmentID = operationDepartment.getDepartment().getDepartmentID();
                    int index = search.searchIndexDepartment(campaign.getDepartments(),
                            departmentID);
                    operationDepartment.deleteDepartmentFromEmployee(campaign.getEmployee(), departmentID);
                    operationDepartment.deleteDepartment(index);
                    operationDepartment.setDepartment(null);
                    System.out.println("Отдел удален");
                    return;
                }
                case 0 -> {
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
                case 0 -> {
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
                        int index = search.searchIndexPost(campaign.getPosts(), scanner.nextInt());
                        operationPost.setPost(campaign.getPosts().get(index));
                        System.out.println(operationPost.getPost());
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Неверно указан id должности");
                        break;
                    }

                    editPost();
                }
                case 0 -> {
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
                    System.out.println(campaign.getPosts());
                    System.out.println("Введите id должности которую хотите удалить");
                    int postID = scanner.nextInt();
                    if (campaign.getPosts().size() != 0) {
                        int indexCam = search.searchIndexPost(campaign.getPosts(), postID);
                        if (indexCam != -1) {
                            campaign.deletePost(indexCam);
                            operationPost.deletePostInDepartment(campaign.getDepartments(), postID);
                            System.out.println("Должность удалена");
                        } else {
                            System.out.println("Должность с таким id не найдена");
                        }
                    } else {
                        System.out.println("Нет доступных должностей");
                    }
                }
                case 0 -> {
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
                    operationEmployee.createEmployee(surname, name, patronymic, dateOfBirth);
                }
                case 0 -> {
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
                case 0 -> {
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
                case 0 -> {
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
                        operationEmployee.setEmployee(operationEmployee.takeEmployee(operation.getSearch().searchEmployeeFCs(FCs)));
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
                case 0 -> {
                    return;
                }
                default -> def();
            }
        }
    }
}