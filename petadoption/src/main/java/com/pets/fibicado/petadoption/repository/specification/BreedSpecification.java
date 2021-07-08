package com.pets.fibicado.petadoption.repository.specification;

import com.pets.fibicado.petadoption.model.Breed;
import com.pets.fibicado.petadoption.model.PetType;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public interface BreedSpecification {

    static Specification<Breed> getBreedsOfPetType(String petTypeName){
        if(Objects.isNull(petTypeName)){
            return null;
        }else{
            return (Specification<Breed>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("petType").get("petType"), petTypeName);
        }

    }

    static Specification<PetType> getPetTypeSpecification(String petTypeName){
        if(Objects.isNull(petTypeName)){
            return null;
        }else{
            return (Specification<PetType>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("petType"), petTypeName);
        }

    }
}
