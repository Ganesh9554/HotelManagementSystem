package com.HotelManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import com.HotelManagementSystem.Model.Hotel;


public interface HotelService {

	int saveHotel(Hotel hotel);
	
	Hotel updateHotel(Hotel hotel);
	
	String deleteHotel( int id);
	
	Optional<Hotel> getOneHotel(int id);
	
	List<Hotel> getAllHotel();
	
}
