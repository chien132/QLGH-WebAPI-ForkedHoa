package com.cuoiky.QuanLyGiaoHang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuoiky.QuanLyGiaoHang.model.TaskDetail;
import com.cuoiky.QuanLyGiaoHang.repository.TaskDetailRepository;

@Service
public class TaskDetailService {

	@Autowired
	private TaskDetailRepository repo;
	
	public List<TaskDetail> listAll(){
		return repo.findAll();
	}
	
	public void save(TaskDetail taskDetail) {
		repo.save(taskDetail);
	}
	
	public TaskDetail get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	//lấy task theo id tài xế
	public List<TaskDetail> layTaskTheoId(int idTaiXe) {
		return repo.layTask(idTaiXe);
	}
	// chat
	public void updateChat(String strChat,int idTaskDetail) {
		repo.updateChat(strChat, idTaskDetail);
	}
	
	//lay taskdetails sao taskid
	public List<TaskDetail> layTaskdetailsTheotaskId(int taskId) {
		return repo.layTaskDetailTheoTaskID(taskId);
	}

}












