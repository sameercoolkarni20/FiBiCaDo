package com.pets.fibicado.petadoption.dao;

import com.pets.fibicado.petadoption.model.Breed;
import com.pets.fibicado.petadoption.model.Customer;
import com.pets.fibicado.petadoption.repository.BreedRepository;
import com.pets.fibicado.petadoption.repository.specification.BreedSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class BreedDAO {

    @Autowired
    private BreedRepository breedRepository;

    public List<Breed> getAllBreeds(){
        return breedRepository.findAll();
    }

    public Optional<Breed> getBreedById(Long breedId){
        return breedRepository.findById(breedId);
    }

    public Breed insertNewBreed(Breed breed){
        Long breedId = breed.getBreedId();
        Optional<Breed> breedById = getBreedById(breedId);
        if(breedById.isEmpty()){
            return breedRepository.save(breed);
        }else{
            return breedById.get();
        }

    }

    public List<Breed> getAllBreedsOfPetType(String petType){

        return breedRepository.findAll(BreedSpecification.getBreedsOfPetType(petType));

    }

}
