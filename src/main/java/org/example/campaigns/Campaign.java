package org.example.campaigns;

import org.example.data.Data;
import java.io.Serializable;

public class Campaign implements Serializable {

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
