package com.cuoiky.QuanLyGiaoHang.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cuoiky.QuanLyGiaoHang.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	@Transactional
	@Modifying
	@Query("DELETE FROM Client v WHERE v.username= :username")
	void xoaClientTheoUsername(@Param("username") String username);
}
