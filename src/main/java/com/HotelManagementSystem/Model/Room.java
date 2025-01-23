package com.HotelManagementSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {
	@Id
	@GeneratedValue
	private int roomId;
	private String hotelName;
	private int roomNumber; 
	private String roomType;
	private String roomAvailStatus;
	private long dayPrice;
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="hotel_id_fk")
	private Hotel hotel;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="booking_id_fk")
	private Booking booking;

}
