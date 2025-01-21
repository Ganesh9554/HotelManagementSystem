package com.HotelManagementSystem.Controller;

import java.util.List;

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

import com.HotelManagementSystem.Model.Room;
import com.HotelManagementSystem.Service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private RoomService roomService;

	@PostMapping("/saveroom")
	public ResponseEntity<String> saveRoom(@RequestBody Room room) {
		int roomnumber = roomService.saveRoom(room);
		return new ResponseEntity<String>("room saved with room number " + roomnumber, HttpStatus.CREATED);

	}

	@PutMapping("/updateroom")
	public ResponseEntity<Room> updateRoom(@RequestBody Room room) {

		return new ResponseEntity<Room>(roomService.updateRoom(room), HttpStatus.OK);
	}

	@DeleteMapping("/deleteroom/{id}")
	public ResponseEntity<String> deleteRoom(@PathVariable int id) {
		return new ResponseEntity<String>(roomService.deleteRoom(id), HttpStatus.OK);
	}

	@GetMapping("/getoneroom/{id}")
	public ResponseEntity<Room> getOneRoom(int id) {
		return new ResponseEntity<Room>(roomService.getOneRoom(id), HttpStatus.OK);
	}
    @GetMapping("/getallrooms")
	public ResponseEntity<List<Room>> getAllRooms(){
    	return new ResponseEntity<List<Room>>(roomService.getAllRooms(),HttpStatus.OK);
    }

}
