package org.example.operations;

import org.example.campaigns.Campaign;
import org.example.campaigns.Department;

import java.io.Serializable;
import java.util.List;

public class Report implements Serializable {

    private Campaign campaign;

    public Report() {

    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public void departments() {
        System.out.println(this.campaign.data.getDepartments());
    }

    public void posts() {
        System.out.println(this.campaign.data.getPosts());
    }

    public void employees() {
        System.out.println(this.campaign.data.getEmployee());
    }

    public void averageSalary() {

    }

    public void averageSalaryDepartments() {

    }

    public void topExpensiveEmployee() {

    }

    public void topDevoteesEmployee() {

    }
}
