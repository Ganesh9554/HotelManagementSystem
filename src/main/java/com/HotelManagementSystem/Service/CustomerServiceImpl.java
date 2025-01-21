package com.HotelManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelManagementSystem.Model.Customer;
import com.HotelManagementSystem.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public int saveCustomer(Customer customer) {
		      
		return customerRepository.save(customer).getCustomerId();
		
	}

	@Override
	public String updateCustomer(Customer customer) {
		
	Optional<Customer> cst=	customerRepository.findById(customer.getCustomerId());
	
	if(cst.isPresent()) {
		customerRepository.save(customer);
	}
	return "customer updated successfully";
	}

	@Override
	public Optional<Customer> getOneCustomer(int id) {
		return customerRepository.findById(id);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public String deleteCustomer(int id) {
		 customerRepository.deleteById(id);
		 return "customer deleted successfully";
	}

}
