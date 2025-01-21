package com.HotelManagementSystem.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HotelManagementSystem.Model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
	Optional<Customer> findByCustomerName(String cname);
	
}
