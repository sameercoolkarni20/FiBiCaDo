package com.pets.fibicado.petadoption.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Breed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long breedId;

    @OneToOne
    private PetType petType;

    private String breedName;

    public Breed(){}
}
