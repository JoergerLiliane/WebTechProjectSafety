package com.example.Safety.api;

//@Entity
public class Guardian {

   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/

    private Long id;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private boolean isGuardian;
    private int priorityLevel;


    //Constructor
    public Guardian(Long id, String firstName, String lastName, int phoneNumber, boolean isGuardian, int priorityLevel) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.isGuardian = isGuardian;
        this.priorityLevel = priorityLevel;
    }

    public Guardian(String firstName, String lastName, int phoneNumber, boolean guardian, int priorityLevel) {
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

    public Guardian() {}

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
        return isGuardian;
    }


    public void setGuardian(boolean guardian) {
        this.isGuardian = guardian;
    }



    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }





   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Thing)) return false;

        Thing thing = (Thing) o;

        if (getPrice() != thing.getPrice()) return false;
        if (getId() != null ? !getId().equals(thing.getId()) : thing.getId() != null) return false;
        return getName() != null ? getName().equals(thing.getName()) : thing.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getPrice();
        return result;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    } */

}
