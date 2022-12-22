package com.example.Safety.api;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserCreateOrUpdateRequest {



        @Size(min = 3, message = "Please provide a first name with 3 characters or more.")
        private String firstName;

        @NotBlank(message = "The last name must not be empty.")
        private String lastName;


        @Pattern(
                regexp = "MALE|FEMALE|DIVERSE|UNKOWN",
                message = "Please provide 'MALE', 'FEMALE', 'DIVERSE' or 'UNKNOWN' for gender"
        )


    private String gender;
    private List<Long> guardianId;
    private int phoneNumber;
    private boolean user;

    public UserCreateOrUpdateRequest () {}


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
        return user;
    }

    public void setUser(boolean user) {
        this.user = user;
    }

    public List<Long> getGuardianId() {
        return guardianId;
    }

    public void setGuardianId(List<Long> guardianId) {
        this.guardianId = guardianId;
    }

}
