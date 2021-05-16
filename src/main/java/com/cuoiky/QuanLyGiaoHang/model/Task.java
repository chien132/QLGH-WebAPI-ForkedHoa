package com.cuoiky.QuanLyGiaoHang.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date pickup;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dropoff;
	
	private boolean approve;
	private boolean taskpublic;
	private boolean cancel;
	
	@ManyToOne
	@JoinColumn(name = "clientid")
	private Client client;
	
	@OneToMany(mappedBy = "task",fetch = FetchType.EAGER)
	private Collection<TaskDetail> taskDetails;
	
	public Task() {}

	public Task(int id, Date pickup, Date dropoff, boolean approve, boolean taskpublic, boolean cancel, Client client,
			Collection<TaskDetail> taskDetails) {
		this.id = id;
		this.pickup = pickup;
		this.dropoff = dropoff;
		this.approve = approve;
		this.taskpublic = taskpublic;
		this.cancel = cancel;
		this.client = client;
		this.taskDetails = taskDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPickup() {
		return pickup;
	}

	public void setPickup(Date pickup) {
		this.pickup = pickup;
	}

	public Date getDropoff() {
		return dropoff;
	}

	public void setDropoff(Date dropoff) {
		this.dropoff = dropoff;
	}

	public boolean isApprove() {
		return approve;
	}

	public void setApprove(boolean approve) {
		this.approve = approve;
	}

	public boolean isTaskpublic() {
		return taskpublic;
	}

	public void setTaskpublic(boolean taskpublic) {
		this.taskpublic = taskpublic;
	}

	public boolean isCancel() {
		return cancel;
	}

	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<TaskDetail> getTaskDetails() {
		return taskDetails;
	}

	public void setTaskDetails(Collection<TaskDetail> taskDetails) {
		this.taskDetails = taskDetails;
	}
	
	
	
	
}


















