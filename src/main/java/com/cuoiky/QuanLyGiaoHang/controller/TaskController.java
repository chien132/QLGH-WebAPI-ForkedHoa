package com.cuoiky.QuanLyGiaoHang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cuoiky.QuanLyGiaoHang.model.Client;
import com.cuoiky.QuanLyGiaoHang.model.Task;
import com.cuoiky.QuanLyGiaoHang.service.ClientService;
import com.cuoiky.QuanLyGiaoHang.service.TaskService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class TaskController {
	@Autowired
	private TaskService service;
	
	@Autowired ClientService ClientService;
	
	@GetMapping("/tasks")
	public List<Task> list(){
		return service.listAll();
	}
	
	@GetMapping("/tasks/{id}")
	public Task get(@PathVariable Integer id) {
		return service.get(id);
	}
	
	@PostMapping("/tasks")
	public void add(@RequestBody Task task) {
		service.save(task);
	}
	
	@PostMapping("/tasks/{id}")
	public void update(@RequestBody Task task,@PathVariable Integer id) {
		service.save(task);
	}
	
	@DeleteMapping("/tasks/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	@PostMapping("/AddTaskClient/{idClient}")
	public void addtaskIDclient(@RequestBody Task task,@PathVariable Integer idClient) {
		
		Client temp = ClientService.get(idClient);
		task.setClient(temp);
		
		service.save(task);
	}
	@PostMapping("/UpdateTaskClient/{idClient}")
	public void updateTask(@RequestBody Task task,@PathVariable Integer idClient) {
		
		Client temp = ClientService.get(idClient);
		task.setClient(temp);
		
		service.save(task);
	}
	
	
	//lay task chua approve
	@GetMapping("/task/noApprove")
	public List<Task> layTaskChuaApprove(){
		return service.layTaskTheoApprove(false);
	}
	//lay task theo idCLient
	
	@GetMapping("/task/idclient/{idclient}")
	public List<Task> layTaskTheoIdClient(@PathVariable int idclient){
		return service.layTaskTheoIdClient(idclient);
	}
	
	// lay task theo idLient Ngườn từ User
	@GetMapping("/task/username/{username}")
	public List<Task> layTaskTheoIdclientNguonUser(@PathVariable String username){
		Client client = ClientService.layClientTheoUsername(username);
		int idClient = client.getClientid();
		
		return service.layTaskTheoIdClient(idClient);
	}
}











