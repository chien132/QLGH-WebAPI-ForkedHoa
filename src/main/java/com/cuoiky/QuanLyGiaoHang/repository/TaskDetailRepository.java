package com.cuoiky.QuanLyGiaoHang.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cuoiky.QuanLyGiaoHang.model.TaskDetail;

public interface TaskDetailRepository extends	JpaRepository<TaskDetail, Integer>{
	//lấy task theo id tài xế
	@Query("SELECT v FROM TaskDetail v WHERE v.user.id = :idTaiXe")
	List<TaskDetail> layTask(@Param("idTaiXe") int idTaiXe);
	
	//set lại chat theo id task
	@Transactional
	@Modifying
	@Query("UPDATE TaskDetail v SET v.chat = :strChat WHERE v.id = :idTaskDetail")
	void updateChat(@Param("strChat") String strChat,@Param("idTaskDetail") int idTaskDetail);
	
	//lay task detail theo taskId
	@Query("SELECT v FROM TaskDetail v WHERE v.task.id= :taskId")
	List<TaskDetail> layTaskDetailTheoTaskID(@Param("taskId") int taskId);
	

}
