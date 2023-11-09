package org.example.campaigns;

import java.io.*;
import java.time.LocalDate;

public class Employee implements Externalizable {

    @Serial
    private static final long serialVersionUID = 1L;

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
    private int employeeID;
    private static int numberCreation;

    public Employee(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        numberCreation++;
        this.employeeID = numberCreation;
    }

    public Employee() {
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
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.surname);
        out.writeObject(this.name);
        out.writeObject(this.patronymic);
        out.writeObject(this.dateOfBirth);
        out.writeObject(this.gender);
        out.writeObject(this.telephoneNumber);
        out.writeObject(this.post);
        out.writeObject(this.department);
        out.writeObject(this.chief);
        out.writeObject(this.dateOfEmployment);
        out.writeObject(this.salary);
        out.writeObject(numberCreation);
        out.writeObject(this.employeeID);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.surname = (String) in.readObject();
        this.name = (String) in.readObject();
        this.patronymic = (String) in.readObject();
        this.dateOfBirth = (LocalDate) in.readObject();
        this.gender = (Gender) in.readObject();
        this.telephoneNumber = (String) in.readObject();
        this.post = (Post) in.readObject();
        this.department = (Department) in.readObject();
        this.chief = (Employee) in.readObject();
        this.dateOfEmployment = (LocalDate) in.readObject();
        this.salary = (int) in.readObject();
        numberCreation = (int) in.readObject();
        this.employeeID = (int) in.readObject();
    }
}
