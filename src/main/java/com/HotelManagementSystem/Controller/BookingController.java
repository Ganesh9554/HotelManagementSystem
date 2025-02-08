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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HotelManagementSystem.Exception.CustomerNotFoundException;
import com.HotelManagementSystem.Exception.RoomNotFoundException;
import com.HotelManagementSystem.Model.Booking;
import com.HotelManagementSystem.Model.BookingResponse;
import com.HotelManagementSystem.Model.Customer;
import com.HotelManagementSystem.Repository.CustomerRepository;
import com.HotelManagementSystem.Service.BookingService;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;

@Slf4j
@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@PostMapping("/savebooking")
	public ResponseEntity<BookingResponse> bookHotel(@RequestBody Booking booking) 
			throws RoomNotFoundException,  CustomerNotFoundException{
		log.debug("bookHotel :: Booking: {}", booking);
		BookingResponse br=null;
		String cname=booking.getCustomerName();
		Optional<Customer> customer=customerRepository.findByCustomerName(cname);
		if(customer.isPresent()) {
			 br=bookingService.bookHotel(booking);
		}else {
			throw new CustomerNotFoundException("Please Register");
		}
		return new ResponseEntity<BookingResponse>(br,HttpStatus.CREATED);
	}
	 @PostMapping("/updatebooking")
	public ResponseEntity<BookingResponse> updateBooking(@RequestBody Booking booking)
			throws RoomNotFoundException,CustomerNotFoundException{
		 
		 BookingResponse br=null;
			String cname=booking.getCustomerName();
			Optional<Customer> customer=customerRepository.findByCustomerName(cname);
			if(customer.isPresent()) {
				 br=bookingService.updateBooking(booking);
			}else {
				throw new CustomerNotFoundException("Please Register");
			}
			return new ResponseEntity<BookingResponse>(br,HttpStatus.CREATED);
	 }
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBooking(@PathVariable int id) {
		return new ResponseEntity<String>(bookingService.deleteBooking(id),HttpStatus.OK);
	}
	
	@GetMapping("/getbooking/{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable int id){
		ResponseEntity<Booking> bk=null;
		Optional<Booking> booking= bookingService.getBookingById(id);
		if(booking.isPresent()) {
			bk=new ResponseEntity<Booking>(booking.get(),HttpStatus.OK);
		}
		return bk;
	}
	@GetMapping("/getallBookings")
	public ResponseEntity<List<Booking>> getAllBookings(){
		return new ResponseEntity<List<Booking>>(bookingService.getAllBookings(),HttpStatus.OK);
	}
}
