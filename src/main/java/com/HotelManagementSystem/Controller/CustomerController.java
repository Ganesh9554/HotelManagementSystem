package com.HotelManagementSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HotelManagementSystem.Model.Customer;
import com.HotelManagementSystem.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
   @PostMapping("/savecustomer")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer){
	  int  cid=customerService.saveCustomer(customer);
	   return new ResponseEntity<String>("Thank you for registering! your id is "+cid,HttpStatus.CREATED);
   }
	@PutMapping("/updateCustomer")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer){
		customerService.updateCustomer(customer);
		return new ResponseEntity<String>("Customer data has been updated! Thank You",HttpStatus.OK);
	}
	@GetMapping("/get/{id}")
	 public ResponseEntity<Customer> getOneCustomer(@PathVariable int id){
		ResponseEntity<Customer> customer=null;
		Optional<Customer> cst= customerService.getOneCustomer(id);
		if(cst.isPresent()) {
			customer= new ResponseEntity<Customer>(cst.get(),HttpStatus.OK);
		}
		return customer;
	 }
	@GetMapping("/getall")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomer(),HttpStatus.OK);
	}
	@DeleteMapping("/deletecustomer/{id}")
	public ResponseEntity<String>  deleteCustomer(@PathVariable int id){
		return new ResponseEntity<String>(customerService.deleteCustomer(id),HttpStatus.OK);
	}

	

}
