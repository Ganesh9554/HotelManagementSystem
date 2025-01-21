package com.HotelManagementSystem.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Booking_Table")
public class Booking implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int bookingId;
	
	private String customerName;
	
	private String hotelName;
	
	private LocalDate customerCheckIn;
	
	private LocalDate customerCheckout;
	
	private String roomType;
	
	private Integer roomsRequired;
	
	
	@OneToOne(mappedBy = "booking",cascade = CascadeType.ALL)
	private Customer customer;
	
	@OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
	private List<Room> rooms;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="hotel_id_fk")
	private Hotel hotel;
	
	

}
