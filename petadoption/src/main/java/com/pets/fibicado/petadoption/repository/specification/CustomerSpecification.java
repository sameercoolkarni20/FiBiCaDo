package com.pets.fibicado.petadoption.repository.specification;

import com.pets.fibicado.petadoption.model.Customer;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public interface CustomerSpecification {

    static Specification<Customer> getCustomerByName(String customerName){
        if(Objects.isNull(customerName)){
            return null;
        }else{
            return (root, query, cb) -> cb.equal(root.get("customerName"), customerName);
        }
    }
}
