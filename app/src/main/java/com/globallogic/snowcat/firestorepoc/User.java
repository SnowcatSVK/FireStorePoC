package com.globallogic.snowcat.firestorepoc;

import java.util.Date;

/**
 * Created by snowcat on 26.1.2018.
 */

public class User {

    private String firstName;
    private String lastName;
    private Date dob;
    private int age;
    private String id;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {

        return id;
    }

    public User(String firstName, String lastName, Date dob, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDob() {
        return dob;
    }

    public int getAge() {
        return age;
    }
}
