package org.example.campaigns;

import java.io.Serial;
import java.io.Serializable;

public class Post implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final int postID;
    private static int numberCreation;
    private String postName;

    public Post(String postName) {
        numberCreation++;
        this.postName = postName;
        this.postID = numberCreation;
    }

    public int getNumberCreation() {
        return numberCreation;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public void createPost(String postName) {

    }

    @Override
    public String toString() {
        return "\nID Должности: " + postID +
                " Должность: " + postName;
    }
}
