package com.HotelManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import com.HotelManagementSystem.Model.Customer;


public interface CustomerService {

	int saveCustomer(Customer customer);
	
	String updateCustomer(Customer customer);
	
	Optional<Customer> getOneCustomer(int id);
	
	List<Customer> getAllCustomer();
	
	String deleteCustomer(int id);
	
}
