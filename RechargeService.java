package com.gl.caseStudy.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.gl.caseStudy.bean.Bill;
import com.gl.caseStudy.bean.Offer;


@Repository
@Service
public class RechargeService implements BillDao, OfferDao {
	@Autowired
	private BillRepository repository1;
	@Autowired
	private OfferRepository repository2;

	@Override
	public void offerSave(Offer offer) {
		Offer off=new Offer();
		repository2.save(off);
		

	}

	@Override
	public Long generateId() {
		Long val=repository2.findMaxId();
		if(val==null)
			val=1L;
		else
			val=val+1;
		
		return val;
		
	}

	@Override
	public List<Offer> findAllOffers() {
		List<Offer> offerList=repository2.findAll();
		return offerList;
		
	}

	@Override
	public Offer findAOffer(Long id) {
		Offer off=repository2.getById(id);
		return off;
	}

	@Override
	public void billSave(Bill bill) {
		Bill bi=new Bill();
		repository1.save(bi);

	}

	@Override
	public Long generatetransactionId() {
		Long val=repository1.findMaxTransactionId();
		if(val==null)
			val=100001L;
		else
			val=val+1;
		
		return val;
		
	}

	@Override
	public List<Bill> findAllBills() {
		List<Bill> billList=repository1.findAll();
		return billList;
		
	}

	@Override
	public Bill findABill(Long id) {
		Bill bi=repository1.getById(id);
		return bi;
	}

}
