package com.pets.fibicado.petadoption.dao;

import com.pets.fibicado.petadoption.model.Customer;
import com.pets.fibicado.petadoption.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerDAO {


    private CustomerRepository customerRepository;

    public CustomerDAO(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> getCustomerById(long customerId){
        return customerRepository.findById(customerId);

    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer insertNewCustomer(Customer customer){
        long customerId = customer.getCustomerId();
        Optional<Customer> customerById = getCustomerById(customerId);
        if(customerById.isEmpty()){
            return customerRepository.save(customer);
        }else{
            return customerById.get();
        }

    }


}
