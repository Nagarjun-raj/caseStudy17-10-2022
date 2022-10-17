package com.gl.caseStudy.dao;

import java.util.List;

import com.gl.caseStudy.bean.Bill;
import com.gl.caseStudy.bean.Offer;

public interface OfferDao {
	public void offerSave(Offer offer);
	public Long generateId();
	public List<Offer> findAllOffers();
	public Offer findAOffer(Long id);

}
