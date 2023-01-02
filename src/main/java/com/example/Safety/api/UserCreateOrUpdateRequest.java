package com.example.Safety.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserCreateOrUpdateRequest {



        @Size(min = 3, message = "Please provide a first name with 3 characters or more.")
        private String firstName;

        @NotBlank(message = "The last name must not be empty.")
        private String lastName;

        private String gender;


         @Pattern(
                regexp = "MALE|FEMALE|DIVERSE|UNKOWN",
                message = "Please provide 'MALE', 'FEMALE', 'DIVERSE' or 'UNKNOWN' for gender"

        )
        @Size(min = 3, message = "Please provide a password with 3 characters or more.")
        private String password;



         @Pattern(
                 regexp ="Germany|France|Italy|Spain|Portugal|South Africa|Untited States|United Kingdom",
                 message = "Please choose a valid country.")
         private String country;

       /* private int phoneNumber;
        private boolean isUser;
        private List<Long> guardianId;*/



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



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
