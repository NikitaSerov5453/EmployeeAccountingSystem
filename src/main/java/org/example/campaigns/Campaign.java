package org.example.campaigns;

import org.example.data.Data;
import org.example.operations.*;

import java.io.Serial;
import java.io.Serializable;

public class Campaign implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String campaignName;


    public Campaign(String campaignName) {
        this.campaignName = campaignName;
    }


    public Data data = new Data();

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "campaignName='" + campaignName + '\'' +
                '}';
    }
}
