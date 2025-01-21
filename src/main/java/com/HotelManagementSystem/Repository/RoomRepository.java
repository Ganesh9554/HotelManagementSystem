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
	@Transactional
	@Modifying
	 @Query(value="UPDATE room r SET r.room_avail_status=? WHERE r.room_id=?",nativeQuery = true)
	//@Query("UPDATE Room r SET r.roomAvailStatus = :status WHERE r.roomId =:id")     
	void updateRoomAvailStatus(String status,int id);
}
