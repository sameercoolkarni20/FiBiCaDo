package com.pets.fibicado.petadoption.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long petId;

    private String petName;
    @OneToOne
    private PetType petType;
    @OneToOne
    private Breed breed;

    private Integer ageInMonths;

    @OneToOne
    private Customer customer;

    public Pet(){}

}
