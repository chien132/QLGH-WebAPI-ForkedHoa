package com.cuoiky.QuanLyGiaoHang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuoiky.QuanLyGiaoHang.model.Client;
import com.cuoiky.QuanLyGiaoHang.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repo;
	
	public List<Client> listAll(){
		return repo.findAll();
	}
	
	public void save(Client client) {
		repo.save(client);
	}
	
	public Client get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
