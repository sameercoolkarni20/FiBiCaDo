package com.pets.fibicado.petadoption.repository;

import com.pets.fibicado.petadoption.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PetTypeRepository extends JpaRepository<PetType,Long>, JpaSpecificationExecutor<PetType> {
}
