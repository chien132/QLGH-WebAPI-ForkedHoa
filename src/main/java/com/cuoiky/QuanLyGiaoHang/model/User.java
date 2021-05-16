package com.cuoiky.QuanLyGiaoHang.model;


import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	private String password;
	private String name;
	private String address;
	
	@ManyToOne
	@JoinColumn(name = "roleid")
	private Role role;
	
	public User() {}
	
//	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
//	private Collection<TaskDetail> taskDetails;

	public User(int id, String username, String password, String name, String address, Role role,
			Collection<TaskDetail> taskDetails) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.role = role;
		//this.taskDetails = taskDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


//
//	public Collection<TaskDetail> getTaskDetails() {
//		return taskDetails;
//	}
//
//	public void setTaskDetails(Collection<TaskDetail> taskDetails) {
//		this.taskDetails = taskDetails;
//	}
//	
	
}
