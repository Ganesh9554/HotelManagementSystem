package com.HotelManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HotelManagementSystem.Model.Booking;
import com.HotelManagementSystem.Model.Room;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
   List<Room> findByBookingId(int id);
}
