package com.HotelManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HotelManagementSystem.Model.Hotel;
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
  Hotel findByHotelName(String hotel);

  
}
