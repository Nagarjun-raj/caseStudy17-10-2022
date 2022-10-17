package com.gl.caseStudy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gl.caseStudy.service.OurUsersService;


@Configuration                      //defines bean class
@EnableWebSecurity                  //Allows web authentication
public class OurUsersConfig extends WebSecurityConfigurerAdapter{
	@Autowired                      //possible only when @service, @congig and @bean
	private OurUsersService service;
	
	
	@Bean
	public PasswordEncoder passwordEncoder(){		
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder authority) throws Exception {
		authority.userDetailsService(service);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/loginpage")
		.failureUrl("/loginerror").loginProcessingUrl("/login")
		.permitAll().and().logout()
		.logoutSuccessUrl("/index");
	}
	
	

}
