package com.pets.fibicado.petadoption.dao;

import com.pets.fibicado.petadoption.model.Breed;
import com.pets.fibicado.petadoption.model.PetType;
import com.pets.fibicado.petadoption.repository.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PetTypeDAO {

    @Autowired
    private PetTypeRepository petTypeRepository;

    public List<PetType> getAllPetTypes() {
        return petTypeRepository.findAll();
    }

    public Optional<PetType> getPetTypeById(Long petTypeId) {
        return petTypeRepository.findById(petTypeId);
    }


    public PetType insertNewPetType(PetType petType) {
        Long petTypeId = petType.getPetTypeID();
        Optional<PetType> petTypeById = getPetTypeById(petTypeId);
        if (petTypeById.isEmpty()) {
            return petTypeRepository.save(petType);
        } else {
            return petTypeById.get();
        }

    }
}
