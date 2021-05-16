package com.cuoiky.QuanLyGiaoHang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cuoiky.QuanLyGiaoHang.model.TaskDetail;
import com.cuoiky.QuanLyGiaoHang.service.TaskDetailService;

@RestController
public class TaskDetailController {
	@Autowired
	private TaskDetailService service;
	
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

}
