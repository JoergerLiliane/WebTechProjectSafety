package com.example.Safety.api;

import com.example.Safety.persistenceSQL.UserEntity;

//Daten, welches der Client dem Server sendet, ohne ID
public class GuardianCreateOrUpdateRequest {
    private String firstName;
    private String lastName;
    private String gender;
    private int phoneNumber;
    private boolean guardian;
    private int priorityLevel;
    private Long userId;

    public GuardianCreateOrUpdateRequest(String firstName, String lastName, String gender, int phoneNumber, boolean guardian, int priorityLevel, Long userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.guardian = guardian;
        this.priorityLevel =priorityLevel;
        this.userId=userId;
    }


    public GuardianCreateOrUpdateRequest (){

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

    public boolean isGuardian() {
        return guardian;
    }

    public void setGuardian(boolean guardian) {
        this.guardian = guardian;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
