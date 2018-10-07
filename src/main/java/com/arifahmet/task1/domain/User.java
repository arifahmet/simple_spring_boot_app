package com.arifahmet.task1.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@Table(name = "User")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @NotBlank(message="Name cannot be blank.")
    private String name;
    @Column(name = "phoneNumber")
    @NotBlank(message="Phone number cannot be blank.")
    private String phoneNumber;
    @Column(name = "address")
    @NotBlank(message="Adress cannot be blank.")
    private String address;

    public User(){

    }

    public User(String name, String phoneNumber, String address){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
