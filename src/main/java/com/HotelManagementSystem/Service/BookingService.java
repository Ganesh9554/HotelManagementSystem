package com.HotelManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import com.HotelManagementSystem.Exception.RoomNotFoundException;
import com.HotelManagementSystem.Model.Booking;
import com.HotelManagementSystem.Model.BookingResponse;


public interface BookingService {

	BookingResponse bookHotel(Booking booking) throws RoomNotFoundException;
	 
	BookingResponse updateBooking(Booking booking)throws RoomNotFoundException;
	
	String deleteBooking(int id);
	
	Optional<Booking> getBookingById(int id);
	
	List<Booking> getAllBookings();
}
