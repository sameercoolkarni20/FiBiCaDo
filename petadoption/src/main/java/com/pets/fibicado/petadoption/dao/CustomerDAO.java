package com.pets.fibicado.petadoption.dao;

import com.pets.fibicado.petadoption.model.Customer;
import com.pets.fibicado.petadoption.repository.CustomerRepository;
import com.pets.fibicado.petadoption.repository.specification.CustomerSpecification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerDAO implements UserDetailsService {


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


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      List<Customer> customerList = customerRepository.findAll(CustomerSpecification.getCustomerByName(username));
        if(customerList.size()==1){
            return customerList.get(0);
        }else{
            return null;
        }
    }
}
