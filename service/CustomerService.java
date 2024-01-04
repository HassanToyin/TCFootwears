package com.Ecommerces.TcFootwears.service;

import com.Ecommerces.TcFootwears.dto.CustomerDto;
import com.Ecommerces.TcFootwears.model.Customer;
import com.Ecommerces.TcFootwears.repository.CustomerRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Data
@Service

public class CustomerService {
    private final CustomerRepo customerRepo;

    public Customer createCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();

        customer.setName(customerDto.getName());
        customer.setAddress(customerDto.getAddress());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setEmail(customerDto.getEmail());

        return customerRepo.save(customer);

    }

    public Customer getCustomer(Long id){
        return customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public ArrayList<Customer> getAllCustomer(){
        return (ArrayList<Customer>) customerRepo.findAll();
    }
    public Customer updateCustomer(CustomerDto customerDto, Long ID){
        Customer customer = customerRepo.findById().orElseThrow(()-> new RuntimeException("customer not found"));

        customer.setName(customerDto.getName());
        customer.setAddress(customerDto.getAddress());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setEmail(customerDto.getEmail());

        return customerRepo.save(customer);
    }

    public Customer deleteCustomer(Long id) {
        Customer customer = customerRepo.findById(id).get();
        customerRepo.deleteById(id);
        return customer;
    }
}
