package com.example.Safety.api;

import java.util.List;

public class User {
    /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/

    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private int phoneNumber;
    private boolean isUser;
    private List<Long> guardianId;




    //Constructor
    public User(Long id, String firstName, String lastName, String gender, int phoneNumber, boolean isUser, List<Long> guardianId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.isUser = isUser;
        this.guardianId = guardianId;



    }





    // Getter & Setter

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isUser() {
        return isUser;
    }


    public void setUser(boolean isUser) {
        this.isUser = isUser;
    }


    public List<Long> getGuardianId() {
        return guardianId;
    }

    public void setGuardianId(List<Long> guardianId) {
        this.guardianId = guardianId;
    }
}
