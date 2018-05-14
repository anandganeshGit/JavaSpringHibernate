package com.car2Go.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="person")
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {
	@Id
	@GeneratedValue
	@Column(name="personId",unique=true,nullable=false)
	private long personId;
	@Column(name="firstname",nullable=false)
	private String firstname;
	@Column(name="lastname",nullable=false)
	private String lastname;
	@Column(name="phonenumber")
	private String phonenumber;
	@Column(name="address")
	private String address;
	@Column(name="emailId",nullable=false)
	private String emailId;
	
	public Person(){
		
	}
	
	public Person(long personId, String firstname, String lastname, String phonenumber, String address, String emailId) {
		this.personId = personId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phonenumber = phonenumber;
		this.address = address;
		this.emailId = emailId;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
		
}
