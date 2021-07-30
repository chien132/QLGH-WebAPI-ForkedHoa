package com.cuoiky.QuanLyGiaoHang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cuoiky.QuanLyGiaoHang.model.Invoice;
import com.cuoiky.QuanLyGiaoHang.service.InvoiceService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class InvoiceController {
	
	@Autowired
	private InvoiceService service;
	
	@GetMapping("/invoices")
	public List<Invoice> list(){
		return service.listAll();
	}
	
	@GetMapping("/invoices/{id}")
	public Invoice get(@PathVariable Integer id) {
		return service.get(id);
	}
	
	@PostMapping("/invoices")
	public void add(@RequestBody Invoice invoice) {
		service.save(invoice);
	}
	
//	@PostMapping("/invoices/{id}")
//	public ResponseEntity<?> update(@RequestBody Invoice invoice, @PathVariable Integer id) {
//
//		try {
//			Invoice existInvoice = service.get(id);
//			service.save(invoice);
//			return new ResponseEntity<>(HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
	@PostMapping("/invoices/{id}")
	public void update(@RequestBody Invoice invoice,@PathVariable Integer id) {
		service.save(invoice);
	}
	
	@DeleteMapping("/invoices/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}