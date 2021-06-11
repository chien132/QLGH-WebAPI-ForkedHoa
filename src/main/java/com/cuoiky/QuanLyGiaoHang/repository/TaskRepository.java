package com.cuoiky.QuanLyGiaoHang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cuoiky.QuanLyGiaoHang.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{
	//lay danh sach task theo approve
	@Query("SELECT v FROM Task v WHERE v.approve= :check")
	List<Task> layTaskTheoApprove(@Param("check") boolean check);
	//lay task theo id khach hang
	@Query("SELECT v FROM Task v WHERE v.client.id= :idClient")
	List<Task> layTaskByIdClient(@Param("idClient") int idClient);
}
