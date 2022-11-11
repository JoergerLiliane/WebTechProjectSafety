package com.example.Safety.api;

//Daten, welches der Client dem Server sendet, ohne ID
public class PersonCreateRequest {
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private boolean guardian;

    public PersonCreateRequest(String firstName, String lastName, int phoneNumber, boolean guardian) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.guardian = guardian;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isGuardian() {
        return guardian;
    }

    public void setGuardian(boolean guardian) {
        this.guardian = guardian;
    }



}
