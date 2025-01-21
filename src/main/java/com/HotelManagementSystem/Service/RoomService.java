package com.HotelManagementSystem.Service;

import java.util.List;

import com.HotelManagementSystem.Model.Room;


public interface RoomService {
	double calculateTotalPrice(double price, int rooms);

	int saveRoom(Room room);

	Room updateRoom(Room room);

	String deleteRoom(int id);

	Room getOneRoom(int id);

	List<Room> getAllRooms();
}
