package org.example.views;

import org.example.campaigns.Campaign;
import org.example.files.File;
import org.example.files.Serialized;
import org.example.operations.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final Operation operation = new Operation();
    private final OperationEmployee operationEmployee = operation.getOperationEmployee();
    private final OperationDepartment operationDepartment = operation.getOperationDepartment();
    private final OperationPost operationPost = operation.getOperationPost();
    public File file = new File();
    private final View view = new View();
    private Campaign campaign;

    public Menu() {

    }

    public void start() {
        controlCompanyMenu();
    }

    public void controlCompanyMenu() {//Создание кампании/Загрузка кампании
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
                view.printErrSetNumber();
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
                        view.printSetBirthday();
                        scanner.nextLine();
                        operationEmployee.editDateOfBirth(scanner.nextLine());
                    } catch (DateTimeException e) {
                        view.printErrDataFormat();
                    }
                }
                case 3 -> {
                    view.printChooseGender();
                    operationEmployee.editGender(scanner.nextInt());
                }
                case 4 -> {
                    view.printSetTelephoneNumber();
                    operationEmployee.editTelephoneNumber(scanner.next());
                }
                case 5 -> {
                    if (campaign.getDepartments().size() != 0) {
                        view.printSelectDepartmentFromList(campaign.getDepartments());
                        int index = operationDepartment.searchIndexDepartment(campaign.getDepartments(), scanner.nextInt());
                        if (operationEmployee.getEmployee().getDepartment() != null) {
                            operationEmployee.cleanDepartmentAndPost();
                        }
                        operationEmployee.editDepartment(campaign.getDepartments().get(index));
                        campaign.getDepartments().get(index).getEmployee().add(operationEmployee.getEmployee());

                    } else {
                        view.printErrDepartmentAvailable();
                    }
                }
                case 6 -> {
                    if (operationEmployee.getEmployee().getDepartment() == null) {
                        view.printErrDepartmentSpecified();
                    } else if (operationEmployee.getEmployee().getDepartment().getPosts().size() == 0) {
                        view.printErrPostsAvailable();
                    } else {
                        view.printSelectPostFromList(operationEmployee.getEmployee().getDepartment().getPosts());
                        int index = operationPost.searchIndexPost(operationEmployee.getEmployee().getDepartment().getPosts(), scanner.nextInt());
                        operationEmployee.editPost(operationEmployee.getEmployee().getDepartment().getPosts().get(index));
                    }

                }
                case 7 -> {
                    view.printSetSalary();
                    operationEmployee.editSalary(scanner.nextInt());
                }
                case 8 -> {
                    while (true) {
                        view.setDateOfEmployment();
                        try {
                            operationEmployee.editDateOfEmployment(scanner.nextLine());
                            break;
                        } catch (DateTimeException e) {
                            view.printErrDataFormat();
                        }
                    }
                }
                case 9 -> {
                    int index = operationEmployee.searchIndexEmployee(campaign.getEmployee(), operationEmployee.getEmployee().getEmployeeID());
                    operationEmployee.deleteEmployee(index);
                    operationEmployee.setEmployee(null);
                    view.printEmployeeDeleted();
                    return;

                }
                case 0 -> {
                    return;
                }

                default -> view.printErrSetNumber();
            }
        }
    }

    private void editFCsMenu() {//Редактирование ФИО
        while (true) {
            view.printEditFCsMenu();
            switch (scanner.nextInt()) {
                case 1 -> {
                    view.printSetSurname();
                    scanner.nextLine();
                    operationEmployee.editSurname(scanner.nextLine());
                }
                case 2 -> {
                    view.printSetName();
                    scanner.nextLine();
                    operationEmployee.editName(scanner.nextLine());
                }
                case 3 -> {
                    view.printSetPatronymic();
                    scanner.nextLine();
                    operationEmployee.editPatronymic(scanner.nextLine());
                }
                case 0 -> {
                    return;
                }
                default -> view.printErrSetNumber();
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
                    Serialized.serialized(operation.getCampaign(), campaign.getCampaignName(), view.mainSavePath());
                    Serialized.serialized(operation.getCampaign(), campaign.getCampaignID() + "." +
                            campaign.getCampaignName() + "." +
                            campaign.hashCode(), view.backUpPath());
                    return;
                }
                default -> view.printErrSetNumber();
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
                    view.printSetDepartmentName();
                    scanner.nextLine();
                    operationDepartment.createDepartment(scanner.nextLine());
                    view.printDepartmentCreated();
                }
                case 0 -> {
                    return;
                }
                default -> view.printErrSetNumber();
            }
        }
    }

    private void departmentEditMenu() {//выбор отдела для редактирования
        while (true) {
            view.printDepartmentEditMenu();
            switch (scanner.nextInt()) {
                case 1 -> {
                    view.printSetIDDepartmentFromEdit();
                    try {
                        int index = operationDepartment.searchIndexDepartment(campaign.getDepartments(), scanner.nextInt());
                        operationDepartment.setDepartment(campaign.getDepartments().get(index));
                        System.out.println(operationDepartment.getDepartment());
                    } catch (IndexOutOfBoundsException e) {
                        view.printErrIDDepartment();
                        break;
                    }
                    editDepartment();
                }
                case 0 -> {
                    return;
                }
                default -> view.printErrSetNumber();
            }
        }
    }

    private void editDepartment() { //Редактирование отдела
        while (true) {
            view.printEditDepartment();
            switch (scanner.nextInt()) {
                case 1 -> {
                    view.printSetDepartmentName();
                    scanner.nextLine();
                    if (operationDepartment.getDepartment() != null) {
                        operationDepartment.editDepartmentName(scanner.nextLine());
                        System.out.println(operationDepartment.getDepartment());
                    } else {
                        view.printErrDepartmentNotSelected();
                    }
                    view.printDepartmentNameChanged();
                }
                case 2 -> {
                    view.printSetIDDepartmentEmployeeYouWantAppointChief();
                    System.out.println(operationDepartment.getDepartment().getEmployee());
                    try {
                        if (operationDepartment.getDepartment() != null) {
                            int index = operationEmployee.searchIndexEmployee(operationDepartment.getDepartment().getEmployee(), scanner.nextInt());
                            operationDepartment.editDepartmentChief(operationDepartment.getDepartment().getEmployee().get(index));
                            view.printNewChiefAppointed();
                        } else {
                            view.printErrDepartmentNotSelected();
                        }
                    } catch (IndexOutOfBoundsException e) {
                        view.printErrIDEmployee();
                    }
                }
                case 3 -> {
                    view.printSetNamePostYouWantAdd();
                    operationPost.setDepartment(operationDepartment.getDepartment());
                    scanner.nextLine();
                    operationPost.createPost(scanner.nextLine());
                    view.printPostCreated();
                }
                case 4 -> {
                    System.out.println(operationDepartment.getDepartment().getPosts());
                    view.printSetIDPostYouWantDelete();
                    int postID = scanner.nextInt();
                    if (operationDepartment.getDepartment().getPosts().size() != 0) {
                        int index = operationPost.searchIndexPost(operationDepartment.getDepartment().getPosts(), postID);
                        if (index != -1) {
                            operationEmployee.deletePostFromEmployee(campaign.getEmployee(), postID);
                            operationDepartment.getDepartment().getPosts().remove(index);
                            view.printPostDeleted();
                        } else {
                            view.printErrIDPost();
                        }
                    } else {
                        view.printErrPostsAvailable();
                    }
                }
                case 5 -> {
                    System.out.println(operationDepartment.getDepartment().getEmployee());
                    view.printSetIDEmployeeYouWantDeleted();
                    int employeeID = scanner.nextInt();
                    if (operationDepartment.getDepartment().getEmployee().size() != 0) {
                        int index = operationEmployee.searchIndexEmployee(operationDepartment.getDepartment().getEmployee(), employeeID);
                        if (index != -1) {
                            operationDepartment.getDepartment().getEmployee().get(index).setDepartment(null);
                            operationDepartment.getDepartment().getEmployee().get(index).setPost(null);
                            operationDepartment.getDepartment().getEmployee().remove(index);
                            view.printEmployeeDeleted();
                        } else {
                            view.printErrIDEmployee();
                        }
                    } else {
                        view.printErrEmployeeAvailable();
                    }
                }
                case 6 -> {
                    int departmentID = operationDepartment.getDepartment().getDepartmentID();
                    int index = operationDepartment.searchIndexDepartment(campaign.getDepartments(),
                            departmentID);
                    operationDepartment.deleteDepartmentFromEmployee(campaign.getEmployee(), departmentID);
                    operationDepartment.deleteDepartment(index);
                    operationDepartment.setDepartment(null);
                    view.printDepartmentDeleted();
                    return;
                }
                case 0 -> {
                    return;
                }
                default -> view.printErrSetNumber();
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
                default -> view.printErrSetNumber();
            }
        }
    }

    private void postEditMenu() {
        while (true) {
            view.printPostEditMenu();
            switch (scanner.nextInt()) {
                case 1 -> {
                    view.printSetIDPostFromEdit();
                    try {
                        int index = operationPost.searchIndexPost(campaign.getPosts(), scanner.nextInt());
                        operationPost.setPost(campaign.getPosts().get(index));
                        System.out.println(operationPost.getPost());
                        editPost();
                    } catch (IndexOutOfBoundsException e) {
                        view.printErrIDPost();
                    }
                }
                case 0 -> {
                    return;
                }
                default -> view.printErrSetNumber();
            }
        }
    }

    private void editPost() {
        while (true) {
            view.printEditPost();
            switch (scanner.nextInt()) {
                case 1 -> {
                    view.printSetPostName();
                    scanner.nextLine();
                    if (operationPost.getPost() != null) {
                        operationPost.getPost().setPostName(scanner.nextLine());
                        System.out.println(operationPost.getPost());
                    } else {
                        view.printErrPostNotSelected();
                    }
                    view.printPostNameChanged();
                }
                case 2 -> {
                    System.out.println(campaign.getPosts());
                    view.printSetIDPostYouWantDelete();
                    int postID = scanner.nextInt();
                    if (campaign.getPosts().size() != 0) {
                        int indexCam = operationPost.searchIndexPost(campaign.getPosts(), postID);
                        if (indexCam != -1) {
                            campaign.deletePost(indexCam);
                            operationPost.deletePostInDepartment(campaign.getDepartments(), postID);
                            view.printPostDeleted();
                        } else {
                            view.printErrIDPost();
                        }
                    } else {
                        view.printErrPostsAvailable();
                    }
                }
                case 0 -> {
                    return;
                }
                default -> view.printErrSetNumber();
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
                    view.printSetSurname();
                    String surname = scanner.next();
                    view.printSetName();
                    String name = scanner.next();
                    view.printSetPatronymic();
                    String patronymic = scanner.next();
                    view.printSetBirthday();
                    scanner.nextLine();
                    while (true) {
                        try {
                            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                            LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);
                            if (dateOfBirth.getYear() > 1923 && dateOfBirth.getYear() < LocalDate.now().minusYears(18).getYear()) {
                                operationEmployee.createEmployee(surname, name, patronymic, dateOfBirth);
                                break;
                            } else {
                                view.printErrDataFormat();
                            }
                        } catch (DateTimeException e) {
                            view.printErrDataFormat();
                        }
                    }
                }
                case 0 -> {
                    return;
                }
                default -> view.printErrSetNumber();
            }
        }

    }

    private void employeeEditMenu() {
        while (true) {
            view.printEmployeeEditMenu();
            switch (scanner.nextInt()) {
                case 1 -> {
                    view.printSetIDEmployeeFromEdit();
                    try {
                        int index = operationEmployee.searchIndexEmployee(campaign.getEmployee(), scanner.nextInt());
                        operationEmployee.setEmployee(campaign.getEmployee().get(index));
                        System.out.println(operationEmployee.getEmployee());
                    } catch (IndexOutOfBoundsException e) {
                        view.printErrIDEmployee();
                        break;
                    }
                    editEmployeeMenu();
                }
                case 0 -> {
                    return;
                }
                default -> view.printErrSetNumber();
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
                        view.printErrDateEmployment();
                    }
                }
                case 0 -> {
                    return;
                }
                default -> view.printErrSetNumber();
            }
        }
    }

    private void searchEmployeeMenu() {
        while (true) {
            view.printSearchEmployeeMenu();
            switch (scanner.nextInt()) {
                case 1 -> {
                    view.printSetIDEmployee();
                    int id = scanner.nextInt();
                    try {
                        int index = operationEmployee.searchIndexEmployee(campaign.getEmployee(), id);
                        operationEmployee.setEmployee(campaign.getEmployee().get(index));
                        if (operationEmployee.getEmployee() != null) {
                            view.printEmployee(operationEmployee.getEmployee());
                            editEmployeeMenu();
                        } else {
                            view.printErrSetNumber();
                        }
                    } catch (NullPointerException e) {
                        view.printErrEmployeeID(id);
                    }
                }
                case 2 -> {
                    view.printAllEmployees(campaign.getEmployee());
                    view.printSetFCsEmployee();
                    scanner.nextLine();
                    String FCs = scanner.nextLine();
                    try {
                        operationEmployee.setEmployee(operationEmployee.takeEmployee(operation.getSearch().searchEmployeeFCs(FCs)));
                        if (operationEmployee.getEmployee() != null) {
                            view.printEmployee(operationEmployee.getEmployee());
                            editEmployeeMenu();
                        } else {
                            view.printErrSetNumber();
                        }
                    } catch (NullPointerException e) {
                        view.printErrEmployee(FCs);
                    }
                }
                case 3 -> {
                    view.printSetPostName();
                    scanner.nextLine();
                    String post = scanner.nextLine();
                    try {
                        operationEmployee.setEmployee(operationEmployee.takeEmployee(operation.getSearch().searchEmployeePost(post)));
                        if (operationEmployee.getEmployee() != null) {
                            view.printEmployee(operationEmployee.getEmployee());
                            editEmployeeMenu();
                        } else {
                            view.printErrSetNumber();
                        }
                    } catch (NullPointerException e) {
                        view.printErrPost(post);
                    }
                }
                case 4 -> {
                    view.printSetDepartmentName();
                    scanner.nextLine();
                    String department = scanner.nextLine();
                    try {
                        operationEmployee.setEmployee(operationEmployee.takeEmployee(operation.getSearch().searchEmployeeDepartment(department)));
                        if (operationEmployee.getEmployee() != null) {
                            view.printEmployee(operationEmployee.getEmployee());
                            editEmployeeMenu();
                        } else {
                            view.printErrSetNumber();
                        }
                    } catch (NullPointerException e) {
                        view.printErrDepartment(department);
                    }
                }
                case 5 -> {
                    view.printSetFCsChief();
                    scanner.nextLine();
                    String chief = scanner.nextLine();
                    try {
                        operationEmployee.setEmployee(operationEmployee.takeEmployee(operation.getSearch().searchEmployeeChief(chief)));
                        if (operationEmployee.getEmployee() != null) {
                            view.printEmployee(operationEmployee.getEmployee());
                            editEmployeeMenu();
                        } else {
                            view.printErrSetNumber();
                        }
                    } catch (NullPointerException e) {
                        view.printErrChief(chief);
                    }
                }
                case 0 -> {
                    return;
                }
                default -> view.printErrSetNumber();
            }
        }
    }
}