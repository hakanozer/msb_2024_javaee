package com.works.repositories;

import com.works.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c where upper(c.email) = upper(?1) and c.password = ?2")
    Optional<Customer> customerLogin(String email, String password);

    //@Query(value = "select * from public.customer where email = ?1 and password  = ?2", nativeQuery = true)
    //@Query(value = "call customerLogin(?1, ?2)", nativeQuery = true)
    //Optional<Customer> login(String email, String password);
}