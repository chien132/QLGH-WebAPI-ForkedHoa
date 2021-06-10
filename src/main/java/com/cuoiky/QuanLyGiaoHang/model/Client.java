package com.cuoiky.QuanLyGiaoHang.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clientid;
	
	private String company;
	private String phone;
	private String address;
	
	private String username;
	
//	@OneToMany(mappedBy = "client",fetch = FetchType.EAGER)
//	private Collection<Task> task;
	
	
	public Client() {}

	

	public Client(int clientid, String company, String phone, String address,String username) {
		//, Collection<Task> task
		this.clientid = clientid;
		this.company = company;
		this.phone = phone;
		this.address = address;
		this.username = username;
//		this.task = task;
	}



	public int getClientid() {
		return clientid;
	}


	public void setClientid(int clientid) {
		this.clientid = clientid;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}


//	public Collection<Task> getTask() {
//		return task;
//	}
//
//
//	public void setTask(Collection<Task> task) {
//		this.task = task;
//	}
//	
	
}
