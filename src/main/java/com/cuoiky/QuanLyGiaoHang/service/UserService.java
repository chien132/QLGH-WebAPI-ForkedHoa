package com.cuoiky.QuanLyGiaoHang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuoiky.QuanLyGiaoHang.model.User;
import com.cuoiky.QuanLyGiaoHang.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> listAll(){
		return repo.findAll();
	}
	
	public void save(User user) {
		repo.save(user);
	}
	
	public User get(Integer id) {
		
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	// lay user hien tai
	public List<User> layUserHienTai(String username,String password) {
		return repo.layUserHienTai(username, password);
	}
	
	// lay user theo role 
	public List<User> getUserTheoRole(Integer roleid){
		return repo.layUserTheoRole(roleid);
	}
	// lay user bang username
	public List<User> layUserBangUsername(String username){
		return repo.layUserBangUsername(username);
	}
	// xoa user bang username
	public void xoaUserBangUsername(String username) {
		repo.xoaUserBangUsername(username);
	}
	
}








































