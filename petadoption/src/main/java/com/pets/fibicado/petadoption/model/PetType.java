package com.pets.fibicado.petadoption.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PetType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long petTypeID;

    @Column(unique = true)
    private String petType;

    public PetType(){}
}
