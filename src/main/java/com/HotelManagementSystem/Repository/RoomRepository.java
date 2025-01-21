package com.HotelManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.HotelManagementSystem.Model.Room;

import jakarta.transaction.Transactional;
@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

	List<Room> findByRoomTypeAndRoomAvailStatus(String rt,String status);
	Room findByRoomNumber(int roomnumber);
	@Modifying
	@Transactional
	 @Query("UPDATE room_table rt SET rt.room_avail_status = :status WHERE rt.room_id =:id")     
	void updateRoomAvailStatus(int id,String status);
}
