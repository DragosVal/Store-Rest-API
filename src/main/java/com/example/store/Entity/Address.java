package com.example.store.Entity;


import javax.persistence.*;
import javax.persistence.Entity;


@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String city;
    private int numberOfStreet;
    private String street;

    public Address(){}

    public Address(String city, int numberOfStreet, String street) {
        this.city = city;
        this.numberOfStreet = numberOfStreet;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumberOfStreet() {
        return numberOfStreet;
    }

    public void setNumberOfStreet(int numberOfStreet) {
        this.numberOfStreet = numberOfStreet;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", numberOfStreet=" + numberOfStreet +
                ", street='" + street + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(!( obj instanceof Address)){
            return false;
        }
        Address address = (Address) obj;
        if( ( address.getCity().equals(this.city) ) & ( address.getNumberOfStreet() == this.numberOfStreet ) & ( address.getStreet().equals(this.street) ) )
            return true;
        else
            return false;
    }
}
