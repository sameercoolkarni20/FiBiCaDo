package com.pets.fibicado.petadoption.controller;

import com.pets.fibicado.petadoption.authentication.JwtTokenUtil;
import com.pets.fibicado.petadoption.dao.BreedDAO;
import com.pets.fibicado.petadoption.dao.CustomerDAO;
import com.pets.fibicado.petadoption.dao.PetDAO;
import com.pets.fibicado.petadoption.dao.PetTypeDAO;
import com.pets.fibicado.petadoption.model.*;
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

    @GetMapping(path = "/pettypes/{petType}")
    public List<PetType> getPetTypeByName(@PathVariable String petType){
        return petTypeDAO.getPetTypeByName(petType);
    }

    @GetMapping(path = "/customers")
    public List<Customer> getAllCustomersData(){
        return customerDAO.getAllCustomers();
    }

    @GetMapping(path = "/customers/{customerId}")
    public Optional<Customer> getBreedsByPetType(@PathVariable Integer customerId){
         return customerDAO.getCustomerById(customerId);
    }

    @GetMapping(path = "/breeds/{petType}")
    public List<Breed> getBreedsByPetType(@PathVariable String petType){
        return breedDAO.getAllBreedsOfPetType(petType);
    }

    @GetMapping(path = "/pets/{customerID}")
    public List<Pet> getAllPetsForCustomer(@PathVariable Integer customerID){
        return petDAO.getAllPetsForCustomer(customerID);
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

    @PostMapping(path = "/logout")
    public String logout(@RequestBody LogoutRequest request){
        String token = request.getJwtToken();
        String username = request.getUsername();
        JwtTokenUtil.logoutUserToken(token);
        return "User "+username+" is logged out .Token is invalidated ";
    }

}
