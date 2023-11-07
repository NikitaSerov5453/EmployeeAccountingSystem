package org.example.operations;

import org.example.campaigns.Department;
import org.example.campaigns.Post;
import org.example.campaigns.Campaign;
import org.example.files.Serialized;
import org.example.campaigns.Employee;
import org.example.views.Menu;
import org.example.views.View;

import java.util.HashSet;
import java.util.Scanner;

public class Operation {
    private final Scanner scanner = new Scanner(System.in);
    private Report report = new Report();
    private Search search = new Search();

    private View view = new View();

    private Department department;
    private Campaign campaign;
    private Employee employee;

    public Operation() {

    }

    public View getView() {
        return view;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Campaign createCompany() {
        System.out.println("Введите название кампании:");
        String campaignName = scanner.nextLine();
        this.campaign = new Campaign(campaignName);
        report.setCampaign(campaign);
        search.setCampaign(campaign);
        Serialized.serialized(campaign, campaignName + campaign.hashCode());
        System.out.println("Ваша кампания: " + campaignName + " создана\n");
        return campaign;
    }

    public void loadCampaign(String file) {
        Serialized.deserialized(file);
    }

    public void editCampaign() {

    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void createDepartment(String nameDepartment) {
        Department department = new Department(nameDepartment);
        campaign.data.addDepartments(department);
    }

    public void deleteDepartment() {
        campaign.data.deleteDepartment(this.department.getDepartmentID() - 1);
    }

    public void editDepartmentName(String name) {
        this.department.setDepartmentName(name);
    }

    public void editDepartmentChief(int newChiefEmployeeID) {
        this.department.setChief(department.getEmployee().get(newChiefEmployeeID));
    }

    public void createEmployee(String surname, String name, String patronymic) {
        Employee employee = new Employee(surname, name, patronymic);
        campaign.data.addEmployee(employee);
    }

    public void deleteEmployee() {

    }

    public void editEmployee() {

    }

    public void editSurname() {

    }

    public void editName() {

    }

    public void editPatronymic() {

    }

    public void editDateOfBirth() {

    }

    public void editGender() {

    }

    public void editTelephoneNumber() {

    }

    public void editDepartment() {

    }

    public void editPost() {

    }

    public void editChief() {

    }

    public void editSalary() {

    }

    public void createPost(String namePost) {
        campaign.data.addPosts(new Post(namePost));
    }

    public void deletePost() {

    }

    public Employee takeEmployee(HashSet<Employee> employees) {
        System.out.println("Выберете нужного сотрдуника:");
        view.printHashSet(employees);
        int id = scanner.nextInt();
        int counter = 1;
        for (Employee employee : employees) {
            if (counter == id) {
                return employee;
            } else {
                counter++;
            }
        }
        return null;
    }

}
