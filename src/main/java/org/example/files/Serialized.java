package org.example.files;

import java.io.*;

public class Serialized implements Serializable{

    public Serialized() {

    }

    public static void serialized(Object obj, String fileName, String path){
        try(FileOutputStream fileOutputStream = new FileOutputStream(path + fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object deserialized(String fileName) {
        Object obj;
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
             obj = objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

}
