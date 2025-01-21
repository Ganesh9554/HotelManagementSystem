package com.HotelManagementSystem.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Hotel_Table")
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
	
	
	private Booking booking;
	
	
	
	
	

}
