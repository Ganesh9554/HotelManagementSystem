package com.HotelManagementSystem.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hotel {
	@Id
	@GeneratedValue
	
	private int hotelId;
	private String hotelName;
	private String hotelAddress;
	private Integer hotelRating;
	private Long hotelContactNumber;
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	private List<Room> rooms;
	
	@OneToMany(cascade =CascadeType.ALL )
	private List<Booking> booking;
	
	
	
	
	

}
