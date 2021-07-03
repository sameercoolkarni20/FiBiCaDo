package com.pets.fibicado.petadoption.repository;

import com.pets.fibicado.petadoption.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetTypeRepository extends JpaRepository<PetType,Long> {
}
