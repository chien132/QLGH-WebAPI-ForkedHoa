package com.cuoiky.QuanLyGiaoHang.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cuoiky.QuanLyGiaoHang.model.Client;
import com.cuoiky.QuanLyGiaoHang.service.ClientService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class ClientController {

	@Autowired
	private ClientService service;
	
	@GetMapping("/clients")
	public List<Client> list(){
		return service.listAll();
	}
	
	@GetMapping("/clients/{id}")
	public Client get(@PathVariable Integer id) {
		return service.get(id);
	}
	
	@PostMapping("/clients")
	public void add(@RequestBody Client client) {
		service.save(client);
	}
	@PostMapping("/clients/{id}")
	public void update(@RequestBody Client client,@PathVariable Integer id) {
		service.save(client);
	}
	
	@DeleteMapping("/clients/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	// xoa client theo username
	@PostMapping("/client/delete/{username}")
	public void xoaClientTheoUsername(@PathVariable String username) {
		service.xoaClienttheousername(username);
	}
	
	
}


































