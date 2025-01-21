package com.HotelManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelManagementSystem.Model.Hotel;
import com.HotelManagementSystem.Model.Room;
import com.HotelManagementSystem.Repository.HotelRepository;
import com.HotelManagementSystem.Repository.RoomRepository;

@Service

public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private HotelRepository hotelRepository;
	
	

	@Override
	public double calculateTotalPrice(double price, int rooms) {
		return rooms * price;

	}

	@Override
	public int saveRoom(Room room) {
		Hotel hotel=hotelRepository.findByHotelName(room.getHotelName());
	hotel.getRooms().add(room);
	room.setHotel(hotel);
		return roomRepository.save(room).getRoomNumber();
	}

	@Override
	public Room updateRoom(Room room) {
		Optional<Room> rm = roomRepository.findById(room.getRoomNumber());
		if (rm.isPresent()) {
			Hotel hotel=hotelRepository.findByHotelName(room.getHotelName());
			hotel.getRooms().add(room);
			room.setHotel(hotel);
			roomRepository.save(room);
		}
		return room;
	}

	@Override
	public String deleteRoom(int id) {
		roomRepository.deleteById(id);
		return "room deleted successfully";
	}

	@Override
	public Room getOneRoom(int id) {
		return roomRepository.findByRoomNumber(id);

	}

	@Override
	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}

}
