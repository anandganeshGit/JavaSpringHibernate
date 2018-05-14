package com.car2Go.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.car2Go.pojo.User;

@Entity
@Table (name = "user")
@PrimaryKeyJoinColumn(name = "personId")
public class User extends Person {
		
	@Column (name = "username")
	private String username;
	
	@Column (name = "password")
	private String password;
	
	@Column (name = "role")
	private String role;
	
	
	public User(){
	}

	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
