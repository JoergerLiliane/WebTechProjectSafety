package com.example.Safety.persistenceSQL;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity (name = "Benutzer")
public class UserEntity {

    //Automatische Schlüssel Generierung
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Erzeugen eines nummerischen Wert, welches hochzählt
    @Column(name = "id_user")

    private Long id;


    @Column (name = "first_name_user", nullable = false)

    private String firstName;


    @Column (name = "last_name_user", nullable = false)
    private String lastName;

    @Column (name = "gender_user", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column (name = "phone_number_user", nullable = true)
    private int phoneNumber;


    @Column (name = "is_user", nullable = true)
    private boolean isUser;

    @Column (name = "country", nullable = true)
    private String country;

    @Column (name = "userName", nullable = false)
    private String userName;

    @Column (name = "passWord", nullable = false)
    private String password;


    //1:N Beziehung = User können mehrere Guardians haben
    @OneToMany (mappedBy = "user", fetch = FetchType.EAGER)
    public List<GuardianEntity> guardianId = new ArrayList<>();


    //Für Hibernate Mapping



    //Constructor
    public UserEntity(String firstName, String lastName, Gender gender, String country, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.country= country;
        this.userName= userName;
        this.password=password;




    }


    public UserEntity() {

    }

    //Getter & Setter
    public Long getId() {
        return id;
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


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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

    public void setUser(boolean user) {
        this.isUser = user;
    }

    public List<GuardianEntity> getGuardianId() {
        return guardianId;
    }

    public void setGuardianId(List<GuardianEntity> guardianId) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
