package com.gl.caseStudy.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.caseStudy.bean.OurUsers;


@Repository
public interface OurUsersRepository extends JpaRepository<OurUsers, String> {
	Optional<OurUsers> findUserByUsername(String username);

}
