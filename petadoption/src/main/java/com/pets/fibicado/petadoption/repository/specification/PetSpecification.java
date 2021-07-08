package com.pets.fibicado.petadoption.repository.specification;

import com.pets.fibicado.petadoption.model.Pet;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public interface PetSpecification {

    static Specification<Pet> getPetListForCustomer(Integer customerID){
        if(Objects.isNull(customerID)){
            return null;
        }else{
            return (root, query, cb) -> cb.equal(root.get("customer").get("customerId"), customerID.toString());
        }
    }
}
