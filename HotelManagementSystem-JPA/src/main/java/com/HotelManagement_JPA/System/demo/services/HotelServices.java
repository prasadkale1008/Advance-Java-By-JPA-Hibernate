package com.HotelManagement_JPA.System.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelManagement_JPA.System.demo.entity.Hotel;
import com.HotelManagement_JPA.System.demo.repository.HotelRepository;

@Service 
public class HotelServices {
	@Autowired
	private HotelRepository hotelRepository;
	
	//getting the data 
	public List<Hotel> getAllHotel(){
		return hotelRepository.findAll();
	}
	//saving data
	
	public Hotel saveHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}
	
	//updating 
	public Hotel updateHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}
	
	public Hotel GetHotelById(Long id) {
		return hotelRepository.findById(id).orElse(null);
	}
	
	//delete hotel by id 
	public boolean deleteHotelById(Long id) {
		if(hotelRepository.existsById(id)) {
			hotelRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	
}
