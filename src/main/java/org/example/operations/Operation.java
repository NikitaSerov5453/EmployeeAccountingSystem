package org.example.operations;

import org.example.campaigns.Campaign;
import org.example.files.Serialized;
import org.example.views.View;

import java.util.Scanner;

public class Operation {


    private final Scanner scanner = new Scanner(System.in);
    private final Report report = new Report();
    private final Search search = new Search();
    private final View view = new View();
    private final OperationDepartment operationDepartment = new OperationDepartment();
    private final OperationPost operationPost = new OperationPost();
    private final OperationEmployee operationEmployee = new OperationEmployee();


    private Campaign campaign;


    public Operation() {

    }

    public Search getSearch() {
        return search;
    }

    public Report getReport() {
        return report;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public OperationDepartment getOperationDepartment() {
        return operationDepartment;
    }

    public OperationPost getOperationPost() {
        return operationPost;
    }

    public OperationEmployee getOperationEmployee() {
        return operationEmployee;
    }

    public Campaign createCompany() {
        System.out.println("Введите название кампании:");
        String campaignName = scanner.nextLine();
        this.campaign = new Campaign(campaignName);
        report.setCampaign(campaign);
        search.setCampaign(campaign);
        operationDepartment.setCampaign(campaign);
        operationEmployee.setCampaign(campaign);
        operationPost.setCampaign(campaign);
        Serialized.serialized(campaign, campaignName, view.mainSavePath());
        System.out.println("Ваша кампания: " + campaignName + " создана\n");
        return campaign;
    }

    public Campaign loadCampaign(String file) {
        campaign = (Campaign) Serialized.deserialized(file);
        report.setCampaign(campaign);
        search.setCampaign(campaign);
        operationDepartment.setCampaign(campaign);
        operationEmployee.setCampaign(campaign);
        operationPost.setCampaign(campaign);
        System.out.println("Ваша кампания: " + campaign.getCampaignName() + " загружена\n");
        return campaign;
    }

}
