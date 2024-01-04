package com.Ecommerces.TcFootwears.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column( name = "phoneNumber", nullable = false)
    private String phoneNumber;

    public void setPhoneNumber(String phoneNumber) {
    }

    public void setAddress(String address) {
    }

    public void setName(String name) {
    }

    public void setEmail(String email) {
    }

    //@OneToMany(mappedBy = "customer")
    //private List<Order> orders;
}
