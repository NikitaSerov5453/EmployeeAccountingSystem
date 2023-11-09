package org.example.operations;

import org.example.campaigns.Campaign;
import org.example.campaigns.Post;

public class OperationPost {

    private Post post;

    private Campaign campaign;

    public OperationPost() {

    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public void deletePost() {

    }

    public void createPost(String namePost) {
        campaign.addPosts(new Post(namePost));
    }

}
