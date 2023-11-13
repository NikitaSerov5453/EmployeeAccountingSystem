package org.example.campaigns;

import org.example.views.View;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    private LocalDate dateOfEmployment;
    private int salary;
    private int employeeID;
    private static int numberCreation;

    public Employee(String surname, String name, String patronymic, LocalDate dateOfBirth) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
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

    public String getDateOfBirth() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return dateOfBirth.format(dateTimeFormatter);
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public String getDateOfEmployment() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return dateOfEmployment.format(dateTimeFormatter);
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

    public Employee getChief() {
        if (department != null) {
            return department.getChief();
        }
        return null;
    }



    @Override
    public String toString() {
        return "\nСотрудник: " +
                "\nФИО: " + surname + " " + name + " " + patronymic +
                "\nДата рождения: " + getDateOfBirth() +
                "\nПол: " + gender +
                "\nНомер телефона: " + telephoneNumber +
                "\nДолжность: " + post +
                "\nОтдел: " + department +
                "\nРуководитель: " + View.printChief(getChief()) +
                "\nДата трудоустройства: " + getDateOfEmployment() +
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
        this.dateOfEmployment = (LocalDate) in.readObject();
        this.salary = (int) in.readObject();
        numberCreation = (int) in.readObject();
        this.employeeID = (int) in.readObject();
    }
}
