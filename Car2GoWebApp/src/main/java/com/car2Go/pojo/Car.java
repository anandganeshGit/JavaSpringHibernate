package com.car2Go.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="car")
public class Car {
	@Id
	@GeneratedValue( strategy =GenerationType.AUTO)
	@Column (name="carId",unique=true,nullable=false)
	private int carId;

	@Column(name="carNo")
	private String carNo;
	
	@Column(name="carName")
	private String carName;
	
	@Column(name="perhourrate")
	private float perhourrate;
	
	@Column(name="availability")
	private String availability;
	
	@Column(name = "yearofmanufacture", nullable = false)
	private int yearofmanufacture;
	
	@Column (name = "rating")
	private String rating;
	
	@PrimaryKeyJoinColumn(name="cartypeId")
    private int cartypeId;
	
	public Car() {
	}


	public Car(String availability, int yearofmanufacture,String carNo, String carName, float perhourrate,int cartypeId,String rating) {

		this.availability = availability;
		this.perhourrate=perhourrate;
		this.rating = rating;
		this.carNo = carNo;
        this.cartypeId = cartypeId;
        this.yearofmanufacture=yearofmanufacture;
		this.rating=rating;	
}


	public int getCarId() {
		return carId;
	}


	public void setCarId(int carId) {
		this.carId = carId;
	}


	public String getCarNo() {
		return carNo;
	}


	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}


	public String getCarName() {
		return carName;
	}


	public void setCarName(String carName) {
		this.carName = carName;
	}


	public float getPerhourrate() {
		return perhourrate;
	}


	public void setPerhourrate(float perhourrate) {
		this.perhourrate = perhourrate;
	}


	public String getAvailability() {
		return availability;
	}


	public void setAvailability(String availability) {
		this.availability = availability;
	}


	public int getYearofmanufacture() {
		return yearofmanufacture;
	}


	public void setYearofmanufacture(int yearofmanufacture) {
		this.yearofmanufacture = yearofmanufacture;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public int getCartypeId() {
		return cartypeId;
	}


	public void setCartypeId(int cartypeId) {
		this.cartypeId = cartypeId;
	}

}
