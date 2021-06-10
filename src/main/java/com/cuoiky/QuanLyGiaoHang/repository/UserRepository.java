package com.cuoiky.QuanLyGiaoHang.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cuoiky.QuanLyGiaoHang.model.User;

public interface UserRepository extends	JpaRepository<User, Integer>{

	@Query("SELECT v FROM User v WHERE v.username = :tendangnhap and v.password = :matkhau")
	List<User> layUserHienTai(@Param("tendangnhap") String tendangnhap,@Param("matkhau") String matkhau);
	
	@Query("SELECT v FROM User v WHERE v.role.id = :roleid")
	List<User> layUserTheoRole(@Param("roleid") int roleid);
	
	// lấy user ra theo username
	@Query("SELECT v FROM User v WHERE v.username = :username")
	List<User> layUserBangUsername(@Param("username") String username);
	
	// xoa user bang username
	@Transactional
	@Modifying
	@Query("DELETE FROM User v WHERE v.username = :username")
	void xoaUserBangUsername(@Param("username") String username);
}
