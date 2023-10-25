package org.example.humans;

import org.example.campaign.Department;
import org.example.campaign.Post;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {

    private String surname;
    private String name;
    private String patronymic;
    private String FCs = surname + " " + name + " " + patronymic;
    private LocalDate dateOfBirth;
    private String gender;
    private String telephoneNumber;
    private Post post;
    private Department department;
    private Employee chief;
    private LocalDate dateOfEmployment;
    private int salary;
    private int employeeID;
    private final int numberCreation;

    public Employee(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        employeeID++;
        this.numberCreation = employeeID;
    }

    public int getNumberCreation() {
        return numberCreation;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getFCs() {
        return FCs;
    }

    public void setFCs(String FCs) {
        this.FCs = FCs;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getChief() {
        return chief;
    }

    public void setChief(Employee chief) {
        this.chief = chief;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
