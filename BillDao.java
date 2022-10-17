package com.gl.caseStudy.dao;

import java.util.List;

import com.gl.caseStudy.bean.Bill;



public interface BillDao {
	public void billSave(Bill bill);
	public Long generatetransactionId();
	public List<Bill> findAllBills();
	public Bill findABill(Long id);
	
	

}
