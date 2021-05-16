package com.cuoiky.QuanLyGiaoHang.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cuoiky.QuanLyGiaoHang.model.User;

public interface UserRepository extends	JpaRepository<User, Integer>{

	@Query("SELECT v FROM User v WHERE v.username = :tendangnhap and v.password = :matkhau")
	List<User> layUserHienTai(@Param("tendangnhap") String tendangnhap,@Param("matkhau") String matkhau);
}
