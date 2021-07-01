package com.pets.fibicado.petadoption.repository;

import com.pets.fibicado.petadoption.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
