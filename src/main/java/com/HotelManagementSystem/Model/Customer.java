package com.HotelManagementSystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Customer_Table")
public class Customer {
	@Id
	@GeneratedValue
	private int customerId;
	private String customerName;
	private String customerEmail;
	private long cPhoneNumber;
	
	@OneToOne
	@JoinColumn(name="booking_id_fk")
	private Booking booking;
     
    
    
    
     
     
	
	

}
