package com.cuoiky.QuanLyGiaoHang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cuoiky.QuanLyGiaoHang.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}
