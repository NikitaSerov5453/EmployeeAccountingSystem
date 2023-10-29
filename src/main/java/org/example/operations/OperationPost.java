package org.example.operations;

import org.example.campaigns.Campaign;
import org.example.campaigns.Post;

import java.util.Scanner;

public class OperationPost {
    private final Scanner scanner = new Scanner(System.in);
    private Campaign campaign;

    public OperationPost() {

    }

    private void createPost(String namePost) {
        campaign.data.addPosts(new Post(namePost));
    }

    public void deletePost() {

    }

    public void editPost() {

    }

    public void createPostMenu() {
        System.out.println("Введите название должности:");
        scanner.nextLine();
        String postName = scanner.nextLine();
        createPost(postName);
        System.out.println("Должность: " + postName + " создана\n");

    }
}
