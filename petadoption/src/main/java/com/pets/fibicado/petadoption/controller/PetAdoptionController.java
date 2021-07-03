package com.pets.fibicado.petadoption.controller;

import com.pets.fibicado.petadoption.dao.BreedDAO;
import com.pets.fibicado.petadoption.dao.CustomerDAO;
import com.pets.fibicado.petadoption.dao.PetDAO;
import com.pets.fibicado.petadoption.dao.PetTypeDAO;
import com.pets.fibicado.petadoption.model.Customer;
import com.pets.fibicado.petadoption.model.Pet;
import com.pets.fibicado.petadoption.model.Breed;
import com.pets.fibicado.petadoption.model.PetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PetAdoptionController {


    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private BreedDAO breedDAO;
    @Autowired
    private PetTypeDAO petTypeDAO;
    @Autowired
    private PetDAO petDAO;


    @GetMapping(path = "/pets")
    public List<Pet> getAllPetsData(){
       return petDAO.getAllPets();
    }


    @GetMapping(path = "/breeds")
    public List<Breed> getAllBreedsData(){
        return breedDAO.getAllBreeds();
    }


    @GetMapping(path = "/pettypes")
    public List<PetType> getAllPetTypesData(){
        return petTypeDAO.getAllPetTypes();
    }


    @GetMapping(path = "/customers")
    public List<Customer> getAllCustomersData(){
        return customerDAO.getAllCustomers();
    }

    @GetMapping(path = "/customers/{customerId}")
    public Optional<Customer> getCustomerById(@PathVariable Integer customerId){
         return customerDAO.getCustomerById(customerId);
    }

    @PostMapping(path = "/customer")
    public Customer createCustomer(@Valid @RequestBody Customer customer){
        return customerDAO.insertNewCustomer(customer);
    }

    @PostMapping(path = "/pets")
    public Pet createPet(@Valid @RequestBody Pet pet) throws Exception {
        return petDAO.insertNewPet(pet);
    }

    @PostMapping(path = "/pettypes")
    public PetType createPetType(@Valid @RequestBody PetType petType){
        return petTypeDAO.insertNewPetType(petType);
    }

    @PostMapping(path = "/breeds")
    public Breed createBreed(@Valid @RequestBody Breed breed){
        return breedDAO.insertNewBreed(breed);
    }
}
