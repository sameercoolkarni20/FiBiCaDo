package com.pets.fibicado.petadoption.repository;

import com.pets.fibicado.petadoption.model.Breed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BreedRepository extends JpaRepository<Breed,Long> , JpaSpecificationExecutor<Breed> {



}
