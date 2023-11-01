package org.example.campaigns;

import java.io.Serializable;

public class Post implements Serializable {

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

    @Override
    public String toString() {
        return "\nID Должности: " + postID +
                " Должность: " + postName;
    }
}
