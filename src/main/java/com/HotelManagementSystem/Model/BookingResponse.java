package com.HotelManagementSystem.Model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {
	private int booingId;
	  private String hotelName;
	private int numberofrooms;
	private List<Integer> roomnumber;
	private double totalPrice;
	

}
