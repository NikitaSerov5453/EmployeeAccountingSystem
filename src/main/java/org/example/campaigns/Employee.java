package org.example.campaigns;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;

public class Employee implements Serializable, Comparable{

    private String surname;
    private String name;
    private String patronymic;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String telephoneNumber;
    private Post post;
    private Department department;
    private Employee chief;
    private LocalDate dateOfEmployment;
    private int salary;
    private final int employeeID;
    private static int numberCreation;

    public Employee(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        numberCreation++;
        this.employeeID = numberCreation;
    }

    public int getEmployeeID() {
        return employeeID;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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

    @Override
    public String toString() {
        return "\nСотрудник: " +
                "\nФИО: " + surname + " " + name + " " + patronymic +
                "\nДата рождения: " + dateOfBirth +
                "\nПол: " + gender +
                "\nНомер телефона: " + telephoneNumber +
                "\nДолжность: " + post +
                "\nОтдел: " + department +
                "\nРуководитель: " + chief +
                "\nДата трудоустройства: " + dateOfEmployment +
                "\nЗаработная плата: " + salary +
                "\nID Сотрдуника: " + employeeID +
                "\n";
    }


    @Override
    public int compareTo(Object o) {
        return Comparator.comparing(Employee::getSalary)
                .thenComparing(Employee::getDateOfEmployment).compare(this, (Employee) o);
    }
}
