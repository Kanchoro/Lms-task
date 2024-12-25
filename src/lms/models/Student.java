package lms.models;

import lms.enums.Gender;

public class Student {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Gender gender;

    private static Long generateId =1L;

    public Student() {
        this.id=generateId++;
    }

    public Student( String name, String lastName, String email, String password, Gender gender) {
        this.id=generateId++;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "DataBase" +
                "\nId:        " + id +
                "\nName:      " + name +
                "\nLast name:  " + lastName +
                "\nEmail:     " + email +
                "\nPassword:  " + password +
                "\nGender:    " + gender
                ;
    }
}
