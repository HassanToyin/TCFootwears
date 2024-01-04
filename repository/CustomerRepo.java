package com.Ecommerces.TcFootwears.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Ecommerces.TcFootwears.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
