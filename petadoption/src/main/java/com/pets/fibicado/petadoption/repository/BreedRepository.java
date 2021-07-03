package com.pets.fibicado.petadoption.repository;

import com.pets.fibicado.petadoption.model.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedRepository extends JpaRepository<Breed,Long> {
}
