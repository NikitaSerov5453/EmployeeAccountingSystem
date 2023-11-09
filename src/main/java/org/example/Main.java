package org.example;

import org.example.views.Menu;

import java.io.Serializable;

public class Main implements Serializable {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.start();
    }
}