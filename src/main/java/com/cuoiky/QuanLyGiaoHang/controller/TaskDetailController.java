package com.cuoiky.QuanLyGiaoHang.controller;

import java.util.List;

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

import com.cuoiky.QuanLyGiaoHang.model.Task;
import com.cuoiky.QuanLyGiaoHang.model.TaskDetail;
import com.cuoiky.QuanLyGiaoHang.model.User;
import com.cuoiky.QuanLyGiaoHang.service.TaskDetailService;
import com.cuoiky.QuanLyGiaoHang.service.UserService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class TaskDetailController {
	@Autowired
	private TaskDetailService service;
	
	@Autowired
	private UserService userSV;
	
	@GetMapping("/taskdetails")
	public List<TaskDetail> list(){
		return service.listAll();
	}
	
	@GetMapping("/taskdetails/{id}")
	public TaskDetail get(@PathVariable Integer id) {
		return service.get(id);
	}
	
	@PostMapping("/taskdetails")
	public void add(@RequestBody TaskDetail taskDetail) {
		service.save(taskDetail);
	}
	@PostMapping("/taskdetails/{id}")
	public void update(@RequestBody TaskDetail taskDetail,@PathVariable Integer id) {
		service.save(taskDetail);
	}
	
	@DeleteMapping("/taskdetails/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	// lay taskdetails theo id tai xe 
	@GetMapping("/taskdetail/{idtaixe}")
	public List<TaskDetail> layTask(@PathVariable int idtaixe ) {
		return service.layTaskTheoId(idtaixe);
	}
	/// chat
	
	@PostMapping("/chat/{idTaskDetail}")
	public void updateChat(@PathVariable int idTaskDetail,@RequestBody String strChat) {
		service.updateChat(strChat, idTaskDetail);
	}

	// add taskdetails
	@PostMapping("/addTaskdetails/{idUser}")
	public void themTaskDetais(@RequestBody TaskDetail taskDetail,@PathVariable int idUser) {
		// vi luc add user torng taskdetail bij null nen phai gan duoi db;
		User user = userSV.get(idUser);
		taskDetail.setUser(user);
		service.save(taskDetail);
	}
	//lay taskdetail theo taskId
	@GetMapping("/taskdetails/taskId/{taskId}")
	public List<TaskDetail> layTaskdetailsTheoTaskid(@PathVariable int taskId){
		return service.layTaskdetailsTheotaskId(taskId);
	}
	
	
}











































