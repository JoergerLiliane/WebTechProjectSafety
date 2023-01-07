package com.example.Safety.api;

//@Entity
public class Guardian {

    //@Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private int phoneNumber;
    private boolean isGuardian;
    private int priorityLevel;
    private Long userId;
    private User user;




    //Constructor
    public Guardian(Long id, String firstName, String lastName, String gender, int phoneNumber, boolean isGuardian, int priorityLevel, Long userId,  User user) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.isGuardian = isGuardian;
        this.priorityLevel = priorityLevel;
        this.userId = userId;
        this.user = user;


    }





    /*public Guardian(Long id, String firstName, String firstName1, int phoneNumber, boolean guardian) {
    }*/


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

    public boolean isGuardian() {
        return isGuardian;
    }


    public void setGuardian(boolean isGuardian) {
        this.isGuardian = isGuardian;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
