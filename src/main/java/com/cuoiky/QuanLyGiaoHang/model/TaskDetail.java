package com.cuoiky.QuanLyGiaoHang.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "task_detail")
public class TaskDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "assign_drive_id")
	private User user;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date start_task;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date end_task;
	
	private String task_node;
	
	@ManyToOne
	@JoinColumn(name = "task_id")
	private Task task;

	public TaskDetail() {}

	
	
	public TaskDetail(int id, User user, Date start_task, Date end_task, String task_node, Task task) {
		this.id = id;
		this.user = user;
		this.start_task = start_task;
		this.end_task = end_task;
		this.task_node = task_node;
		this.task = task;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getStart_task() {
		return start_task;
	}

	public void setStart_task(Date start_task) {
		this.start_task = start_task;
	}

	public Date getEnd_task() {
		return end_task;
	}

	public void setEnd_task(Date end_task) {
		this.end_task = end_task;
	}

	public String getTask_node() {
		return task_node;
	}

	public void setTask_node(String task_node) {
		this.task_node = task_node;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
	
}















