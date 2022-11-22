package com.ocean.clients.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "clients")
public class Client {

    private
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String phoneNumber;
    private String firstName;
    private String lastName;


    public Client(String firstName, String lastName, String phoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Client() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName =lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Client client))
            return false;
        return Objects.equals(this.id, client.id) && Objects.equals(this.firstName, client.firstName)
                && Objects.equals(this.lastName, client.lastName) && Objects.equals(this.phoneNumber, client.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName, this.phoneNumber);
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + this.id + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName + '\'' + ", phoneNumber='" + this.phoneNumber + '\'' + '}';
    }
}