package com.Ecommerces.TcFootwears.controller;

import com.Ecommerces.TcFootwears.dto.CustomerDto;
import com.Ecommerces.TcFootwears.model.Customer;
import com.Ecommerces.TcFootwears.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDto customerDto){
        Customer createdCustomer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> Customer = customerService.getAllCustomer();
        return new ResponseEntity<>(Customer, HttpStatus.OK);
    }



}
