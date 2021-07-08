package com.pets.fibicado.petadoption.repository;

import com.pets.fibicado.petadoption.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;



public interface PetRepository extends JpaRepository<Pet,Long> , JpaSpecificationExecutor<Pet> {

}
