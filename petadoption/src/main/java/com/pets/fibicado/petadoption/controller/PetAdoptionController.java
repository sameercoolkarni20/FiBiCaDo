package com.pets.fibicado.petadoption.controller;

import com.pets.fibicado.petadoption.model.Customer;
import com.pets.fibicado.petadoption.model.Pet;
import com.pets.fibicado.petadoption.repository.CustomerRepository;
import com.pets.fibicado.petadoption.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PetAdoptionController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping(path = "/pets")
    public List<Pet> getAllPetsData(){
        List<Pet> petList = new ArrayList<>();
        Iterable<Pet> iterablePets = petRepository.findAll();
        iterablePets.forEach(petList::add);
        return petList;
    }

    @GetMapping(path = "/customers")
    public List<Customer> getAllCustomersData(){
        List<Customer> CustomerList = new ArrayList<>();
        Iterable<Customer> iterableCustomers = customerRepository.findAll();
        iterableCustomers.forEach(CustomerList::add);
        return CustomerList;
    }

    @PostMapping(path = "/customer")
    public long createCustomer(@Valid @RequestBody Customer customer){
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer.getCustomerId();
    }

    @PostMapping(path = "/pets")
    public long createPet(@Valid @RequestBody Pet pet){
        long customerId = pet.getCustomer().getCustomerId();
        Customer customer = customerRepository.getById(customerId);
        Pet savedPet = petRepository.save(pet);
        return savedPet.getPetId();
    }

}
