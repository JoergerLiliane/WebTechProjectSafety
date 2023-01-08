package com.example.Safety.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserCreateOrUpdateRequest {



        @Size(min = 3, message = "Please provide a first name with 3 characters or more.")
        private String firstName;

        @NotBlank(message = "The last name must not be empty.")
        private String lastName;


        @Pattern(
                regexp = "MALE|FEMALE|DIVERSE|UNKNOWN",
                message = "Please provide 'MALE', 'FEMALE', 'DIVERSE' or 'UNKNOWN' for gender.")
        private String gender;


         private  int phoneNumber;


        private String country;


         @Size(min = 3, message = "Please provide a username with 3 characters or more.")
        private String userName;



        @Size(min = 3, message = "Please choose a password with 3 characters or more.")
         private String password;






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


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





}
