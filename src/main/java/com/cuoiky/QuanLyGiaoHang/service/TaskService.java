package com.cuoiky.QuanLyGiaoHang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuoiky.QuanLyGiaoHang.model.Task;
import com.cuoiky.QuanLyGiaoHang.model.User;
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
	//lay danh sach task theo approve
	public List<Task> layTaskTheoApprove(boolean check){
		return repo.layTaskTheoApprove(check);
	}
	// lay task theo idClient
	public List<Task> layTaskTheoIdClient(int idClient){
		return repo.layTaskByIdClient(idClient);
	}
	
	// lay task theo username đầu vào là User
//	public List<Task> layTaskTheoUsernameUser(User user){
//		
//	}

}






















