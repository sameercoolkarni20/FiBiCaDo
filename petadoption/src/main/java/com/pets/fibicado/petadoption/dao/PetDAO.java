package com.pets.fibicado.petadoption.dao;

import com.pets.fibicado.petadoption.model.Breed;
import com.pets.fibicado.petadoption.model.Customer;
import com.pets.fibicado.petadoption.model.Pet;
import com.pets.fibicado.petadoption.model.PetType;
import com.pets.fibicado.petadoption.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PetDAO {


    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private BreedDAO breedDAO;
    @Autowired
    private PetTypeDAO petTypeDAO;


    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }

    public Optional<Pet> getPetByPetId(Long petId){
        return petRepository.findById(petId);
    }


    public Pet insertNewPet(Pet pet) throws Exception {
        if(isPetInformationValid(pet)){
            addEntirePetInformation(pet);
            long petId = pet.getPetId();
            Optional<Pet> petByPetId = getPetByPetId(petId);
            if(petByPetId.isEmpty()){
                Pet savedPet = petRepository.save(pet);
                return getPetByPetId(savedPet.getPetId()).get();
            }else{
                return petByPetId.get();
            }
        }else{
            throw new Exception("Invalid information");
        }
    }

    private void addEntirePetInformation(Pet pet) {
        long breedId = pet.getBreed().getBreedId();
        Optional<Breed> breedById = breedDAO.getBreedById(breedId);
        pet.setBreed(breedById.get());


        long petTypeId = pet.getPetType().getPetTypeID();
        Optional<PetType> petTypeById = petTypeDAO.getPetTypeById(petTypeId);
        pet.setPetType(petTypeById.get());

        long customerId = pet.getCustomer().getCustomerId();
        Optional<Customer> customerById = customerDAO.getCustomerById(customerId);
        pet.setCustomer(customerById.get());

    }

    private boolean isPetInformationValid(Pet pet) {
        boolean isValidPet = true;

        Breed breed = pet.getBreed();
        long breedId = breed.getBreedId();

        Optional<Breed> breedById = breedDAO.getBreedById(breedId);

        if(breedById.isEmpty()){
            isValidPet = false;
        }

        PetType petType = pet.getPetType();
        long petTypeID = petType.getPetTypeID();

        Optional<PetType> petTypeById = petTypeDAO.getPetTypeById(petTypeID);
        if(petTypeById.isEmpty()){
            isValidPet = false;
        }

        Customer customer = pet.getCustomer();
        long customerId = customer.getCustomerId();

        Optional<Customer> customerById = customerDAO.getCustomerById(customerId);
        if(customerById.isEmpty()){
            isValidPet = false;
        }

        return isValidPet;
    }

}
