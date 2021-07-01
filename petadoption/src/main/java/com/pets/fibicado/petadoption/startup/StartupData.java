package com.pets.fibicado.petadoption.startup;

import com.pets.fibicado.petadoption.model.Customer;
import com.pets.fibicado.petadoption.model.Pet;
import com.pets.fibicado.petadoption.model.enums.Breed;
import com.pets.fibicado.petadoption.model.enums.PetType;
import com.pets.fibicado.petadoption.repository.CustomerRepository;
import com.pets.fibicado.petadoption.repository.PetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupData implements CommandLineRunner  {

    private PetRepository petRepository;
    private CustomerRepository customerRepository;

    public StartupData(PetRepository petRepository,CustomerRepository customerRepository){
        this.petRepository = petRepository;
        this.customerRepository= customerRepository;
    }


    @Override
    public void run(String... args) throws Exception {
/*

        Customer firstCustomer = new Customer();
        firstCustomer.setCustomerName("Shree");
        firstCustomer.setEmailId("abc@gmail.com");
        firstCustomer.setMobileNumber("9876543210");

        customerRepository.save(firstCustomer);

        Pet firstPet = new Pet();
        firstPet.setPetName("Raja");
        firstPet.setBreed(Breed.DOBERMAN);
        firstPet.setPetType(PetType.DOG);
        firstPet.setAgeInMonths(10);
        firstPet.setCustomer(firstCustomer);
        petRepository.save(firstPet);
*/

        System.out.println("Pet count is "+petRepository.count());
        System.out.println("Customer count is "+customerRepository.count());
    }
}
