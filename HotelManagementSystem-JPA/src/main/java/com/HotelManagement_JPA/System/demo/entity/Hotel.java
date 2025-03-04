package com.HotelManagement_JPA.System.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity//marks this class as an entity class

public class Hotel {
	
	@Id// serve primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)// use for generate unique id 
	private Long id;
	private String name;
	private String hoteltype;
	private String quality;
	
	
	public Hotel(Long id, String name, String hoteltype, String quality) {
		super();
		this.id = id;
		this.name = name;
		this.hoteltype = hoteltype;
		this.quality = quality;
	}
	
	public Hotel() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHoteltype() {
		return hoteltype;
	}
	public void setHoteltype(String hoteltype) {
		this.hoteltype = hoteltype;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	
}



