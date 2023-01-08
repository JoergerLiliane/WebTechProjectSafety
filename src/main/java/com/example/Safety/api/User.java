package com.example.Safety.api;


import java.util.List;

public class User {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private Long id;

    private String firstName;
    private String lastName;
    private String gender;
    private int phoneNumber;
    private boolean isUser;
    private List<Long> guardianId;
    private String country;
    private String userName;
    private String password;


    public User() {
    }

    //Constructor
    public User(Long id, String firstName, String lastName, String gender, int phoneNumber, boolean isUser, List<Long> guardianId, String country, String userName, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.isUser = isUser;
        this.guardianId = guardianId;
        this.country= country;
        this.userName = userName;
        this.password = password;


    }


    //Constructor for UserRestControllerTest

    public User(Long id, String firstName, String lastName, String gender, int phoneNumber, boolean isUser, String country, String userName, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.isUser = isUser;
        this.country= country;
        this.userName = userName;
        this.password = password;

    }


    //Constructor for UserRestControllerTest

    public User(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    //Constructor for UserTest
    public User(String firstName, String lastName, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;

    }


    //UserTest: Inspo Github von Herrn Wider

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phonNumber=" + phoneNumber +
                '}';
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

    public String getPassWord() {
        return password;
    }

    public void setPassWord(String passWord) {
        this.password = passWord;
    }
}
