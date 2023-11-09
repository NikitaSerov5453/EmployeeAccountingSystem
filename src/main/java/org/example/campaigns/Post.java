package org.example.campaigns;

import java.io.*;

public class Post implements Externalizable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int postID;
    private static int numberCreation;
    private String postName;

    public Post(String postName) {
        numberCreation++;
        this.postName = postName;
        this.postID = numberCreation;
    }

    public Post() {
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

    public int getPostID() {
        return postID;
    }

    @Override
    public String toString() {
        return "\nID Должности: " + postID +
                " Должность: " + postName;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.postName);
        out.writeObject(numberCreation);
        out.writeObject(this.postID);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.postName = (String) in.readObject();
        numberCreation = (int) in.readObject();
        this.postID = (int) in.readObject();
    }
}
