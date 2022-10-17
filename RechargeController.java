package com.gl.caseStudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gl.caseStudy.bean.Bill;
import com.gl.caseStudy.bean.Offer;
import com.gl.caseStudy.dao.BillDao;
import com.gl.caseStudy.dao.OfferDao;
import com.gl.caseStudy.dao.RechargeService;




@RestController
public class RechargeController {
	@Autowired
	private  BillDao billDao;
	@Autowired
	private  OfferDao offerDao;
	@Autowired
	private RechargeService service;
	
	@GetMapping("/index")
	public ModelAndView showWelcomePage() {
		ModelAndView mv=new ModelAndView("index");
		List<Offer> offerList=offerDao.findAllOffers();
		mv.addObject("offerList",offerList);
		return mv;
	}
	
	/*@GetMapping("/pergormRech")
	public ModelAndView showACourse(@PathVariable long id) {
		Offer of=offerDao.findAOffer(id);
		Bill bi=billDao.findABill(id);
		ModelAndView mv=new ModelAndView("billReportPage");
		mv.addObject("offer",of);
		mv.addObject("bill",bi);
		return mv;
	}*/
	
	/*@PostMapping("/performRech")
	public ModelAndView selectRadio(@ModelAttribute("offerId") Offer offer) {
		Long id=offerDao.generateId();
		offer.setId(id);
		offerDao.offerSave(offer);
		return new ModelAndView("redirect:/index");
	}*/
	
	@GetMapping("/performRech")
	public ModelAndView saveNewBill(@RequestParam("mobileNumber") String m,
									  @RequestParam("offerId") long oId) {
		long id = service.generateId();
		Bill bill = new Bill();
		Integer n=Integer.parseInt(m);
		bill.setMobileNumber(n);
		bill.setOfferId(oId);
		bill.setTransactionId(id);
		service.billSave(bill);
		Offer offer = service.findAOffer(oId);
		ModelAndView mv = new ModelAndView("transactionReport");
		mv.addObject("offer",offer);
		mv.addObject("bill",bill);
		return mv;
	}
	
	
	
	

}
