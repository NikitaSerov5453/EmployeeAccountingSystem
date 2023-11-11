package org.example.operations;

import org.example.campaigns.Campaign;
import org.example.campaigns.Department;
import org.example.campaigns.Post;

import java.util.List;

public class OperationPost {

    private Post post;

    private Campaign campaign;

    private Department department;

    public OperationPost() {

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

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public void createPost(String postName) {
        Post post = new Post(postName);
        department.addPosts(post);
        campaign.addPosts(post);
    }

    public void deletePostInDepartment(List<Department> departments, int postID) {
        for (Department value : departments) {
            for (int j = 0; j < value.getPosts().size(); j++) {
                if (postID == value.getPosts().get(j).getPostID()) {
                    value.getPosts().remove(j);
                    return;
                }
            }
        }
    }

}
