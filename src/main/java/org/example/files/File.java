package org.example.files;

import org.example.campaigns.Campaign;

import java.io.*;
import java.util.Objects;

public class File implements Serializable{

    private Campaign campaign;
    public int campaignFileName = 0;
    public File() {

    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        Serialized.serialized(campaign, "Campaign" + campaign.hashCode());
        this.campaign = campaign;
    }
}
