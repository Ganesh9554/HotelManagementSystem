package com.HotelManagementSystem.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelManagementSystem.Exception.RoomNotFoundException;
import com.HotelManagementSystem.Model.Booking;
import com.HotelManagementSystem.Model.BookingResponse;
import com.HotelManagementSystem.Model.Customer;
import com.HotelManagementSystem.Model.Hotel;
import com.HotelManagementSystem.Model.Room;
import com.HotelManagementSystem.Repository.BookingRepository;
import com.HotelManagementSystem.Repository.CustomerRepository;
import com.HotelManagementSystem.Repository.HotelRepository;
import com.HotelManagementSystem.Repository.RoomRepository;

import jakarta.transaction.Transactional;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private RoomService roomService;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private RoomRepository roomRepository;

	@Override
	@Transactional
	public BookingResponse bookHotel(Booking booking) throws RoomNotFoundException {
		booking.setRooms(new ArrayList<Room>());
		String status = "available";
		double totalprice = 0.0;
		List<Room> requiredrooms =new ArrayList<Room>();

		Optional<Customer> customer = customerRepository.findByCustomerName(booking.getCustomerName());
		String name=customer.get().getCustomerName();
		System.out.println(name);
		Hotel hotel = hotelRepository.findByHotelName(booking.getHotelName());
		List<Room> nofrooms = hotel.getRooms();
		List<Room> filteredrooms = nofrooms.stream()
				.filter(a -> a.getRoomType().equalsIgnoreCase(booking.getRoomType()))
				.filter(b -> b.getRoomAvailStatus().equalsIgnoreCase(status)).collect(Collectors.toList());
		int numberofrooms = filteredrooms.size();
		List<Integer> roomnumbers = new ArrayList<Integer>();
		
		if (filteredrooms == null || filteredrooms.isEmpty()) {
			throw new RoomNotFoundException("sorry! all rooms are booked");
		} else if (numberofrooms >= booking.getRoomsRequired()) {
			 requiredrooms = filteredrooms.stream().limit(booking.getRoomsRequired())
					.collect(Collectors.toList());
			for (Room room : requiredrooms) {
				booking.getRooms().add(room);
				room.setBooking(booking);
				roomRepository.updateRoomAvailStatus( "occupied",room.getRoomId());
			}
		} else {
			throw new RoomNotFoundException("sorry!we dont have enough rooms as per your request");
		}
		for (Room room : requiredrooms) {
			roomnumbers.add(room.getRoomNumber());
			totalprice = roomService.calculateTotalPrice(room.getDayPrice(), numberofrooms);
		}
		System.out.println(totalprice);
        customer.get(). setBooking(booking);
		booking.setCustomer(customer.get());
		booking.setHotel(hotel);
		hotel.getBooking().add(booking) ; 

		bookingRepository.save(booking);
		BookingResponse br = new BookingResponse(booking.getBookingId(), hotel.getHotelName(),
				booking.getRoomsRequired(), roomnumbers, totalprice);

		return br;
	}

	@Override
	@Transactional
	public BookingResponse updateBooking(Booking booking) throws RoomNotFoundException {
		Optional<Booking> bk = bookingRepository.findById(booking.getBookingId());
		Optional<Customer> customer = customerRepository.findByCustomerName(booking.getCustomerName());
		Hotel hotel = hotelRepository.findByHotelName(booking.getHotelName());
		String status = "available";
		double totalprice = 0.0;
		List<Integer> roomnumbers = new ArrayList<Integer>();
		List<Room> requiredrooms =new ArrayList<Room>();
		if (bk.isPresent()) {

			List<Room> nofrooms = hotel.getRooms();
			List<Room> filteredrooms = nofrooms.stream()
					.filter(a -> a.getRoomType().equalsIgnoreCase(booking.getRoomType()))
					.filter(b -> b.getRoomAvailStatus().equalsIgnoreCase(status)).collect(Collectors.toList());
			int numberofrooms = filteredrooms.size();

			
			if (filteredrooms == null || filteredrooms.isEmpty()) {
				throw new RoomNotFoundException("sorry! all rooms are booked");
			} else if (numberofrooms >= booking.getRoomsRequired()) {
				 requiredrooms = filteredrooms.stream().limit(booking.getRoomsRequired())
						.collect(Collectors.toList());
				
				for (Room room : requiredrooms) {
					booking.getRooms().add(room);
					room.setBooking(booking);
					roomRepository.updateRoomAvailStatus("occupied",room.getRoomId());
				}
			} else {
				throw new RoomNotFoundException("sorry!we dont have enough rooms as per your request");
			}
			for (Room room : requiredrooms) {
				roomnumbers.add(room.getRoomId());
				totalprice = roomService.calculateTotalPrice(room.getDayPrice(), numberofrooms);
			}

			booking.setCustomer(customer.get());
			booking.setRooms(filteredrooms);
			booking.setHotel(hotel);
			hotel.getBooking().add(booking);

			bookingRepository.save(booking);

		}
		BookingResponse br = new BookingResponse(booking.getBookingId(), hotel.getHotelName(),
				booking.getRoomsRequired(), roomnumbers, totalprice);
		return br;
	}

	@Override
	@Transactional
	public String deleteBooking(int id) {
	List<Room> rooms=	bookingRepository.findByBookingId(id);
	
	for (Room room : rooms) {
		roomRepository.updateRoomAvailStatus("available",room.getRoomId());
		
	}
		bookingRepository.deleteById(id);
		return "your booking has been canceled";
	}

	@Override
	public Optional<Booking> getBookingById(int id) {

		return bookingRepository.findById(id);

	}

	@Override
	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}

}
