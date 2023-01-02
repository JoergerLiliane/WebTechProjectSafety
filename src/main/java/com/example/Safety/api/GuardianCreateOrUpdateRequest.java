package com.example.Safety.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//Daten, welches der Client dem Server sendet, ohne ID
public class GuardianCreateOrUpdateRequest {

    private int phoneNumber;
    private boolean guardian;
    private int priorityLevel;
    private Long userId;

    @Size(min = 3, message = "Please provide a firstname with 3 characters or more.")
    private String firstName;

    @NotBlank(message = "The last name must not be empty.")
    private String lastName;

    private String gender;


    @Pattern(
            regexp = "MALE|FEMALE|DIVERSE|UNKOWN",
            message = "Please provide 'MALE', 'FEMALE', 'DIVERSE' or 'UNKNOWN' for gender"

    )



    @Pattern(
            regexp ="Germany|France|Italy|Spain|Portugal|South Africa|Untited States|United Kingdom",
            message = "Please choose a valid country.")
    private String country;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
