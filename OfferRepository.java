package com.gl.caseStudy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gl.caseStudy.bean.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
	@Query("select max(Id) from Offer")
	public Long findMaxId();

	

}
