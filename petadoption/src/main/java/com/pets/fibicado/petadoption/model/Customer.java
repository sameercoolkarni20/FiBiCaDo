package com.pets.fibicado.petadoption.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;
    private String customerName;
    @Column(unique = true)
    private String emailId;
    private String mobileNumber;


    public Customer(){}
}
