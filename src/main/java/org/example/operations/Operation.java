package org.example.operations;

import org.example.campaigns.Department;
import org.example.campaigns.Post;
import org.example.campaigns.Campaign;
import org.example.files.Serialized;
import org.example.campaigns.Employee;
import org.example.views.Menu;

import java.util.Scanner;

public class Operation {
    private final Scanner scanner = new Scanner(System.in);

    private OperationEmployee operationEmployee = new OperationEmployee();
    private OperationDepartment operationDepartment = new OperationDepartment();
    private OperationPost operationPost = new OperationPost();
    private Report report = new Report();
    private Search search = new Search();
    private Campaign campaign;

    public Operation() {

    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public OperationEmployee getOperationEmployee() {
        return operationEmployee;
    }

    public void setOperationEmployee(OperationEmployee operationEmployee) {
        this.operationEmployee = operationEmployee;
    }

    public OperationDepartment getOperationDepartment() {
        return operationDepartment;
    }

    public void setOperationDepartment(OperationDepartment operationDepartment) {
        this.operationDepartment = operationDepartment;
    }

    public OperationPost getOperationPost() {
        return operationPost;
    }

    public void setOperationPost(OperationPost operationPost) {
        this.operationPost = operationPost;
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
        operationDepartment.setCampaign(campaign);
        operationEmployee.setCampaign(campaign);
        operationPost.setCampaign(campaign);
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

}
