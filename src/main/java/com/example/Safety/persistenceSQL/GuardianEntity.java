package com.example.Safety.persistenceSQL;

import com.example.Safety.api.Guardian;
import com.example.Safety.api.User;

import javax.persistence.*;

//Werte innerhalb der Spalte der SQL Tabelle Person

@Entity (name = "guardian")
public class GuardianEntity {

    //Automatische Schlüssel Generierung
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Erzeugen eines nummerischen Wert, welches hochzählt
    @Column (name = "id_guardian")

    private Long id;


    @Column (name = "first_name_guardiam", nullable = false)

    private String firstName;


    @Column (name = "last_name_guardian", nullable = false)
    private String lastName;

    @Column (name = "gender_guardian", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column (name = "phone_number_guardian", nullable = false)
    private int phoneNumber;


    @Column (name = "is_guardian", nullable = false)
    private boolean isGuardian;

    @Column (name = "priorityLevel_guardian", nullable = false)
    private int priorityLevel;

    //N:1 Beziehung = Guardian kann nur 1 User haben
    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn(name = "foreign_key_user", referencedColumnName = "id_user")
    private UserEntity user;




    //Für Hibernate Mapping




    //Constructor
    public GuardianEntity(String firstName, String lastName, Gender gender, int phoneNumber, boolean isGuardian,int priorityLevel, UserEntity user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.isGuardian = isGuardian;
        this.priorityLevel = priorityLevel;
        this.user=user;


    }


    public GuardianEntity() {

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

    public boolean isGuardian() {
        return isGuardian;
    }

    public void setGuardian(boolean guardian) {
        this.isGuardian = guardian;
    }

   /* protected GuardianEntity() {
    }*/

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    /*public void save(GuardianEntity guardianEntity) {
    }*/
}
