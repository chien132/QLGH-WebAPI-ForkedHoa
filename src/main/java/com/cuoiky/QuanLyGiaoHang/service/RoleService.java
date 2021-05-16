package com.cuoiky.QuanLyGiaoHang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuoiky.QuanLyGiaoHang.model.Role;
import com.cuoiky.QuanLyGiaoHang.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repo;
	
	public List<Role> listAll(){
		return repo.findAll();
	}
	
	public void save(Role role) {
		repo.save(role);
	}
	
	public Role get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
