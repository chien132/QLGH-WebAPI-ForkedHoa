package com.cuoiky.QuanLyGiaoHang.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role")
public class Role {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String rolename;
	
	
//	@OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
//	private Collection<User> user;
	
	public Role() {
		
	}

	public Role(int id, String rolename) {
//, Collection<User> user
		this.id = id;
		this.rolename = rolename;
		//this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

//	public Collection<User> getUser() {
//		return user;
//	}
//
//	public void setUser(Collection<User> user) {
//		this.user = user;
//	}

	
	
}
