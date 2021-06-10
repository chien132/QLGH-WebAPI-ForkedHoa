package com.cuoiky.QuanLyGiaoHang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cuoiky.QuanLyGiaoHang.model.Role;
import com.cuoiky.QuanLyGiaoHang.model.User;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	
}
