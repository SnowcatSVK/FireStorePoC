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
