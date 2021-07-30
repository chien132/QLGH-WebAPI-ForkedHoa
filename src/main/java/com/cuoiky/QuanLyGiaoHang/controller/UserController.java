package com.cuoiky.QuanLyGiaoHang.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cuoiky.QuanLyGiaoHang.model.Client;
import com.cuoiky.QuanLyGiaoHang.model.Role;
import com.cuoiky.QuanLyGiaoHang.model.Task;
import com.cuoiky.QuanLyGiaoHang.model.TaskDetail;
import com.cuoiky.QuanLyGiaoHang.model.User;
import com.cuoiky.QuanLyGiaoHang.service.RoleService;
import com.cuoiky.QuanLyGiaoHang.service.TaskDetailService;
import com.cuoiky.QuanLyGiaoHang.service.TaskService;
import com.cuoiky.QuanLyGiaoHang.service.UserService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class UserController {

	@Autowired
	private UserService userSV;
	
	@Autowired 
	RoleService roleSV;
	
	@Autowired
	TaskDetailService taskDetailSV;

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

	@PostMapping("/AddUser/{idRole}")
	public void addtaskIDclient(@RequestBody User user,@PathVariable Integer idRole) {
		
		Role temp = roleSV.get(idRole);
		user.setRole(temp);
		
		userSV.save(user);
	}
	
	
	@GetMapping("/login")
	@ResponseBody
	public List<User> layUserHienTai(@RequestParam("username") String username,@RequestParam("password") String password){
		
		List<User> list = userSV.layUserHienTai(username, password);
		return list;	
	}
	
	//lấy User theo role
	@GetMapping("/users/role/{roleid}")
	public List<User> layUserTheoRole(@PathVariable Integer roleid){
		List<User> list = userSV.getUserTheoRole(roleid);
		
		return list;
	}
	
	// lay user bang username
	@GetMapping("/user/username/{username}")
	public List<User> layUserTheoUsername(@PathVariable String username){
		List<User> list  =  userSV.layUserBangUsername(username);
		return list;
	}
	@PostMapping("/user/delete/{username}")
	public void xoaUserBangUsername(@PathVariable String username) {
		userSV.xoaUserBangUsername(username);
	}
	
	// lay user theo taskid nguon task
	@GetMapping("/user/taskid/{taskid}")
	public User layUsertheoTaskidnguontask(@PathVariable int taskid){
		List<TaskDetail> taskDetail = taskDetailSV.layTaskdetailsTheotaskId(taskid);
		User user = taskDetail.get(0).getUser();
		return user;
	}
}
















