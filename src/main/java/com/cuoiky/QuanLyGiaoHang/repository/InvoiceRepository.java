package com.cuoiky.QuanLyGiaoHang.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cuoiky.QuanLyGiaoHang.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{
	
}
