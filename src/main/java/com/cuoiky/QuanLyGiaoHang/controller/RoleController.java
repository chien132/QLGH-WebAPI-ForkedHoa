package com.cuoiky.QuanLyGiaoHang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cuoiky.QuanLyGiaoHang.model.Role;
import com.cuoiky.QuanLyGiaoHang.service.RoleService;

@RestController
public class RoleController {
	@Autowired
	private RoleService service;
	
	@GetMapping("/roles")
	public List<Role> list(){
		return service.listAll();
	}
	
	@GetMapping("/roles/{id}")
	public Role get(@PathVariable Integer id) {
		return service.get(id);
	}
	
	@PostMapping("/roles")
	public void add(@RequestBody Role role) {
		service.save(role);
	}
	@PostMapping("/roles/{id}")
	public void update(@RequestBody Role role,@PathVariable Integer id) {
		service.save(role);
	}
	
	@DeleteMapping("/roles/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
