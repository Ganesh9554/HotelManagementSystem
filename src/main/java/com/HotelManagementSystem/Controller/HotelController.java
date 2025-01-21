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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HotelManagementSystem.Model.Hotel;
import com.HotelManagementSystem.Service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private HotelService hotelService;
     
	@PostMapping("/savehotel")
	public ResponseEntity<String> saveHotel(@RequestBody Hotel hotel){
		int id=hotelService.saveHotel(hotel);
		return new ResponseEntity<String>("hotel has been saved with id "+id+" ",HttpStatus.CREATED);
	}
   @PutMapping("/updatehotel")
	ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {
		return new ResponseEntity<Hotel>(hotelService.updateHotel(hotel),HttpStatus.OK);
	}
     @DeleteMapping("/deletehotel/{id}")
	ResponseEntity<String> deleteHotel(@PathVariable int id) {
		return new ResponseEntity<String>(hotelService.deleteHotel(id),HttpStatus.OK);
	}
    @GetMapping("/getonehotel/{id}")
	ResponseEntity<Hotel> getOneHotel(@PathVariable int id){
    	ResponseEntity<Hotel> resp=null;
    	Optional<Hotel> ht=hotelService.getOneHotel(id);
    	if(ht.isPresent()) {
    		resp= new ResponseEntity<Hotel>(ht.get(),HttpStatus.OK);
    	}
    	return resp;
    }
     @GetMapping("/getallhotels")
	public ResponseEntity<List<Hotel>> getAllHotel(){
    	 return new ResponseEntity<List<Hotel>>(hotelService.getAllHotel(),HttpStatus.OK);
     }

}
