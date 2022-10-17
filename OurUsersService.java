package com.gl.caseStudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gl.caseStudy.bean.OurUsers;
import com.gl.caseStudy.dao.OurUsersRepository;


@Service
public class OurUsersService implements UserDetailsService{
	@Autowired
	private OurUsersRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		return repository.findById(username).get();
	}
	public void save(OurUsers users) {
		repository.save(users);
	}

}
