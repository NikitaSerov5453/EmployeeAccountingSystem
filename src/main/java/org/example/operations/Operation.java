package org.example.operations;

import org.example.campaigns.Department;
import org.example.campaigns.Post;
import org.example.campaigns.Campaign;
import org.example.files.Serialized;
import org.example.campaigns.Employee;

import java.util.Scanner;

public class Operation {
    private final Scanner scanner = new Scanner(System.in);

    private Campaign campaign;

    public Operation() {

    }

    public void createCompany() {
        System.out.println("Введите название кампании:");
        String campaignName = scanner.nextLine();
        Campaign campaign = new Campaign(campaignName);
        Serialized.serialized(campaign, campaignName + campaign.hashCode());
        System.out.println("Ваша кампания: " + campaignName + " создана\n");
    }

    public void loadCampaign(String file) {
        Serialized.deserialized(file);
    }

    public void editCampaign() {

    }

}
