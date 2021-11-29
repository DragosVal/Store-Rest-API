package com.example.store.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String firstName;
    private String lastName;


    @Column(name = "email", unique = true)
    private String email;
    private LocalDate dateOfBirth;


    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;


    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "user_id")
    private List<Product> productList = new ArrayList<>();


    public User(String firstName, String lastName, String email, LocalDate dateOfBirth, Address address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address){
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addToProductList(Product product){
        productList.add(product);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
