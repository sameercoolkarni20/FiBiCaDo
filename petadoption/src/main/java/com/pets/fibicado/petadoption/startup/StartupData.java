package com.pets.fibicado.petadoption.startup;

import com.pets.fibicado.petadoption.repository.BreedRepository;
import com.pets.fibicado.petadoption.repository.CustomerRepository;
import com.pets.fibicado.petadoption.repository.PetRepository;
import com.pets.fibicado.petadoption.repository.PetTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupData implements CommandLineRunner  {

    private PetRepository petRepository;
    private CustomerRepository customerRepository;
    private PetTypeRepository petTypeRepository;
    private BreedRepository breedRepository;

    public StartupData(PetRepository petRepository,CustomerRepository customerRepository,PetTypeRepository petTypeRepository,BreedRepository breedRepository){
        this.petRepository = petRepository;
        this.customerRepository= customerRepository;
        this.petTypeRepository = petTypeRepository;
        this.breedRepository = breedRepository;
    }


    @Override
    public void run(String... args) throws Exception {
/*
        PetType petType = new PetType();
        petType.setPetType("DOG");

        petTypeRepository.save(petType);
        Breed breed = new Breed();
        breed.setBreedName("Doberman");
        breed.setPetType(petType);
        breedRepository.save(breed);

        Customer firstCustomer = new Customer();
        firstCustomer.setCustomerName("Shree");
        firstCustomer.setEmailId("abc@gmail.com");
        firstCustomer.setMobileNumber("9876543210");
        customerRepository.save(firstCustomer);

        Pet firstPet = new Pet();
        firstPet.setPetName("Raja");
        firstPet.setBreed(breed);
        firstPet.setPetType(petType);
        firstPet.setAgeInMonths(10);
        firstPet.setCustomer(firstCustomer);
        petRepository.save(firstPet);
        System.out.println("Pettype count is "+petTypeRepository.count());
        System.out.println("Breed count is "+breedRepository.count());*/
    }
}
