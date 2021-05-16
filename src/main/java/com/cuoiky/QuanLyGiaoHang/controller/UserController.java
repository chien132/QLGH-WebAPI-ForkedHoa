package com.cuoiky.QuanLyGiaoHang.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cuoiky.QuanLyGiaoHang.model.Role;
import com.cuoiky.QuanLyGiaoHang.model.User;
import com.cuoiky.QuanLyGiaoHang.service.RoleService;
import com.cuoiky.QuanLyGiaoHang.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService userSV;
	
	@Autowired 
	RoleService roleSV;

//	@Autowired
//	UserRepository userRepo;
	
	@GetMapping("/users")
	public List<User> list(){
		return userSV.listAll();
	}
	
	@GetMapping("/users/{id}")
	public User get(@PathVariable Integer id) {
		
		return userSV.get(id);
	}
	
	@PostMapping("/users")
	public void add(@RequestBody User user) {
		
		
		userSV.save(user);
	}
	@PostMapping("/users/{id}")
	public void update(@RequestBody User user,@PathVariable Integer id) {
		userSV.save(user);
	}
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable Integer id) {
		userSV.delete(id);
	}
	
	
	// Thêm và sửa Role vào User
	@PostMapping("/user/{userid}/role/{roleid}")
	public void addUser(@PathVariable Integer userid,@PathVariable Integer roleid) {
		
		User temp = userSV.get(userid);
		Role temp2 = roleSV.get(roleid);
		temp.setRole(temp2);
		
		userSV.save(temp);
	}

	@GetMapping("/login")
	@ResponseBody
	public List<User> layUserHienTai(@RequestParam("username") String username,@RequestParam("password") String password){
		
		List<User> list = userSV.layUserHienTai(username, password);
		return list;	
	}
	

}
















