package com.car2Go.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "booking")
public class Booking {

	@Id
	@GeneratedValue
	@Column (name = "bookingId",unique=true,nullable=false)
	private int bookingId;
	
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="personId")
    private User user;
	
	@Column (name = "bookedFrom")
	private String bookedFrom;
	
	@Column (name = "bookedTill")
	private String bookedTill;
	
	@Column (name = "status")
	private String status;
	
	@Column (name = "carId")
	private int carId;
	
	public Booking(int bookingId,String bookedFrom,String bookedTill,String status,int carId) {
		this.bookingId=bookingId;
		this.bookedTill = bookedTill;
		this.bookedFrom = bookedFrom;
		this.status = status;
		this.carId = carId;
		
	}
	
	public Booking() {
		
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBookedFrom() {
		return bookedFrom;
	}

	public void setBookedFrom(String bookedFrom) {
		this.bookedFrom = bookedFrom;
	}

	public String getBookedTill() {
		return bookedTill;
	}

	public void setBookedTill(String bookedTill) {
		this.bookedTill = bookedTill;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}
	
}
