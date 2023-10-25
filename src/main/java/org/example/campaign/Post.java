package org.example.campaign;

import java.io.Serializable;

public class Post implements Serializable {

    private String postName;
    private int postID;
    private final int numberCreation;

    public Post(String postName) {
        postID++;
        this.postName = postName;
        this.numberCreation = postID;
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
}
