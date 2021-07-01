package com.pets.fibicado.petadoption.model;

import com.pets.fibicado.petadoption.model.enums.Breed;
import com.pets.fibicado.petadoption.model.enums.PetType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long petId;
    private String petName;
    private PetType petType;
    private Breed breed;
    private Integer ageInMonths;

    @OneToOne
    private Customer customer;

    public Pet(){}

}
