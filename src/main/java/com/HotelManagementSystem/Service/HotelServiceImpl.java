package com.HotelManagementSystem.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelManagementSystem.Model.Hotel;
import com.HotelManagementSystem.Model.Room;
import com.HotelManagementSystem.Repository.HotelRepository;


   
@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
	private HotelRepository hotelRepository;
	@Override
	public int saveHotel(Hotel hotel) {
		hotel.setRooms(new ArrayList<Room>());
		return hotelRepository.save(hotel).getHotelId();
	}

	@Override
	public Hotel updateHotel(Hotel hotel) {
		
		Optional<Hotel> ht= hotelRepository.findById(hotel.getHotelId());
		if(ht.isPresent()) {
			hotelRepository.save(hotel);
		}
		return hotel;
	}

	@Override
	public String deleteHotel(int id) {
		 hotelRepository.deleteById(id);
		 return "hotel deleted successfully";
	}

	@Override
	public Optional<Hotel> getOneHotel(int id) {
		
		return hotelRepository.findById(id);
		
	}

	@Override
	public List<Hotel> getAllHotel() {
		
		return hotelRepository.findAll();
	}

}
