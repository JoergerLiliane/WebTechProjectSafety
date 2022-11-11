package com.example.Safety.persistenceSQL;

import javax.persistence.*;

@Entity (name = "persons")

//Werte innerhalb der Spalte der SQL Tabelle Person
public class PersonEntity {

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

    //Für Hibernate Mapping
    protected PersonEntity() {
    }

    //Constructor
    public PersonEntity(String firstName, String lastName, int phoneNumber, boolean guardian) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.guardian = guardian;


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


}
