package com.cuoiky.QuanLyGiaoHang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuoiky.QuanLyGiaoHang.model.Task;
import com.cuoiky.QuanLyGiaoHang.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository repo;
	
	public List<Task> listAll(){
		return repo.findAll();
	}
	
	public void save(Task task) {
		repo.save(task);
	}
	
	public Task get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}

}
