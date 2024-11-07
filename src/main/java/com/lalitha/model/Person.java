package com.lalitha.model;

import com.lalitha.util.IDGen;

public class Person {
    private int id;
    private String firstName;
    private String lastname;
    private String email;

    public Person(String firstName, String lastName, String email) {
        this.id = IDGen.nextIdForPerson();
        this.setFirstName(firstName);
        this.setLastname(lastName);
        this.setEmail(email);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSummary(){
        return "Id: "+id+", Name: "+firstName+" "+lastname+", email: "+email;
    }

}
