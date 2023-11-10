package org.example.operations;

import org.example.campaigns.Campaign;
import org.example.campaigns.Department;
import org.example.campaigns.Post;

public class OperationPost {

    private Post post;

    private Campaign campaign;

    private Department department;

    public OperationPost() {

    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

    public void createPost(String postName) {
        Post post = new Post(postName);
        department.addPosts(post);
        campaign.addPosts(post);
    }

    public void deletePostInDepartment(int indexDep) {
        department.getPosts().remove(indexDep);
    }
    public void deletePost(int indexCamp) {
        campaign.getPosts().remove(indexCamp);
    }
}
