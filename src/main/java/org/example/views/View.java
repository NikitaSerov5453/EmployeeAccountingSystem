package org.example.views;

import org.example.campaigns.Employee;

import java.util.HashSet;

public class View {

    public View() {

    }

    public void printHashSet(HashSet<Employee> hashSet) {
        int counter = 1;
        for (Employee employee : hashSet) {
            System.out.println(counter + ": " + employee);
            counter++;
        }
    }
}
