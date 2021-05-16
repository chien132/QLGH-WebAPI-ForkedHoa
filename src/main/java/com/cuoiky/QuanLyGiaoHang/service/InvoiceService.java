package com.cuoiky.QuanLyGiaoHang.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuoiky.QuanLyGiaoHang.model.Invoice;
import com.cuoiky.QuanLyGiaoHang.repository.InvoiceRepository;



@Service
public class InvoiceService {
	@Autowired
	private InvoiceRepository repo;
	
	public List<Invoice> listAll(){
		return repo.findAll();
	}
	
	public void save(Invoice invoice) {
		repo.save(invoice);
	}
	
	public Invoice get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
