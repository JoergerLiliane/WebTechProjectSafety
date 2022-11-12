package com.example.Safety.persistenceSQL;

import javax.persistence.*;

@Entity (name = "persons")

//Werte innerhalb der Spalte der SQL Tabelle Person
public class GuardianEntity {

    //Automatische Schlüssel Generierung
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Erzeugen eines nummerischen Wert, welches hochzählt
    @Column (name = "id")

    private Long id;


    @Column (name = "first_name", nullable = false)

    private String firstName;


    @Column (name = "last_name", nullable = false)
    private String lastName;


    @Column (name = "phone_number", nullable = false)
    private int phoneNumber;


    @Column (name = "is_guardian", nullable = false)
    private boolean guardian;

    @Column (name = "priorityLevel", nullable = false)
    private int priorityLevel;


    //Für Hibernate Mapping


    //Constructor
    public GuardianEntity(String firstName, String lastName, int phoneNumber, boolean guardian,int priorityLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.guardian = guardian;
        this.priorityLevel = priorityLevel;


    }

    public GuardianEntity(String firstName, String lastName, int phoneNumber, boolean guardian) {
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

    protected GuardianEntity() {
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public void save(GuardianEntity guardianEntity) {
    }
}
