package com.car2Go.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.car2Go.pojo.CarType;

@Entity
@Table (name = "carType")
public class CarType {

	@Id
	@GeneratedValue
	@Column(name="cartypeId",unique=true,nullable=false)
	private int cartypeId;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="cartypeId")
	private Set<Car> cars = new HashSet<Car>();
	
	@Column (name = "carmodel")
	private String carmodel;
	
	@Column (name = "carbrand")
	private String carbrand;
	
	@Column (name = "transmissiontype")
	private String transmissiontype;
	
	@Column (name = "enginetype")
	private String enginetype;
	
	
	@Column (name = "avgrate")
	private double avgrate;
	
	
	@Column (name = "bodytype")
	private String bodytype;
	
	
	public CarType() {
	}
	public CarType(int cartypeId, Set<Car> cars, String carmodel,String carbrand,String transmissiontype, 
			String enginetype,double avgrate, String bodytype) {
		this.cartypeId=cartypeId;
		this.cars=cars;
		this.carmodel=carmodel;
		this.carbrand=carbrand;
		this.bodytype=bodytype;
		this.avgrate=avgrate;
		this.transmissiontype=transmissiontype;
		this.enginetype=enginetype;
		this.bodytype=bodytype;
	}
	public int getCartypeId() {
		return cartypeId;
	}
	public void setCartypeId(int cartypeId) {
		this.cartypeId = cartypeId;
	}
	public Set<Car> getCars() {
		return cars;
	}
	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
	public String getCarmodel() {
		return carmodel;
	}
	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}
	public String getCarbrand() {
		return carbrand;
	}
	public void setCarbrand(String carbrand) {
		this.carbrand = carbrand;
	}
	public String getTransmissiontype() {
		return transmissiontype;
	}
	public void setTransmissiontype(String transmissiontype) {
		this.transmissiontype = transmissiontype;
	}
	public String getEnginetype() {
		return enginetype;
	}
	public void setEnginetype(String enginetype) {
		this.enginetype = enginetype;
	}
	public double getAvgrate() {
		return avgrate;
	}
	public void setAvgrate(double avgrate) {
		this.avgrate = avgrate;
	}
	public String getBodytype() {
		return bodytype;
	}
	public void setBodytype(String bodytype) {
		this.bodytype = bodytype;
	}
}
