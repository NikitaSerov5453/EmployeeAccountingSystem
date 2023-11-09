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

    private final View view = new View();


    private Campaign campaign;


    public Operation() {

    }

    public View getView() {
        return view;
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
        Serialized.serialized(campaign, campaignName);
        System.out.println("Ваша кампания: " + campaignName + " создана\n");
        return campaign;
    }

    public Campaign loadCampaign(String file) {
        campaign = (Campaign) Serialized.deserialized(file);
        report.setCampaign(campaign);
        search.setCampaign(campaign);

        System.out.println("Ваша кампания: " + campaign.getCampaignName() + " загружена\n");
        return campaign;
    }

    public void editCampaign() {

    }

    public void createDepartment(String nameDepartment) {
        Department department = new Department(nameDepartment);
        campaign.addDepartments(department);
    }
}
