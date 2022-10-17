package com.gl.caseStudy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gl.caseStudy.bean.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
	@Query("select max(transactionId) from Bill")
	public Long findMaxTransactionId();

}
