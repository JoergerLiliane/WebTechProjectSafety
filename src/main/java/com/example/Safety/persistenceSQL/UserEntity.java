package com.example.Safety.persistenceSQL;

import com.example.Safety.api.Guardian;
import com.example.Safety.api.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity (name = "Users")
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

    @Column (name = "phone_number_user", nullable = false)
    private int phoneNumber;


    @Column (name = "is_user", nullable = false)
    private boolean isUser;

    //1:N Beziehung = User können mehrere Guardians haben
    @OneToMany (mappedBy = "user", fetch = FetchType.EAGER)
    private List<GuardianEntity> guardian = new ArrayList<>();


    //Für Hibernate Mapping


    //Constructor
    public UserEntity(String firstName, String lastName, Gender gender, int phoneNumber, boolean isUser) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.isUser = isUser;


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

    public List<GuardianEntity> getGuardian() {
        return guardian;
    }

    public void setGuardian(List<GuardianEntity> guardian) {
        this.guardian = guardian;
    }



}
